from jnius import autoclass
from kivy.app import App
from kivy.uix.image import Image
from kivy.clock import Clock
from kivy.graphics.texture import Texture
from kivy.lang import Builder
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.camera import Camera
from kivy.core.window import Window
from kivy.graphics import Rectangle
from kivy.vector import Vector

import cv2
import numpy as np, cv

Hardware = autoclass('org.renpy.android.Hardware')

def imagefilter(img):
    sobel = np.array([
                      [-1. ,0.   ,1.],
                      [-2. ,0.5  ,2.],
                      [-1. ,0.   ,1.]
                     ])
    var = cv2.filter2D(img,cv2.cv.CV_8UC3,sobel)
    return np.flipud(var)

class KivyCamera(Image):
    def check_button(self,dt):
        (x, y, z) = Hardware.magneticFieldSensorReading()
        needle_angle = Vector(x, y).angle((0, 1)) + 90.
        needle_angle1 = Vector(y, z).angle((0, 1)) + 90.
        needle_angle2 = Vector(x, z).angle((0, 1)) + 90.
        print needle_angle, needle_angle1, needle_angle2
        return True
    def __init__(self, fps, **kwargs):
        super(KivyCamera, self).__init__(**kwargs)
        self.snapshot  = None
        self.disparity = 1200
        self.ypos      = 100
        self.xpos      = 20
        sy = 240; sx = 320
        self.camera = Camera(resolution=(sx,sy),play=True)
        self.var    = False
        Clock.schedule_interval(self.update, 1.0 / fps)
        Hardware.magneticFieldSensorEnable(True)
        Clock.schedule_interval(self.check_button,1/10.)
    def update(self, dt):
        self.snapshot = self.camera.texture
        if self.snapshot != None:
            #self.reg = self.snapshot.get_region(0, 0, 50, 50)
            nparr = np.fromstring(self.camera.texture.pixels, dtype=np.uint8)
            b = np.reshape(nparr, (self.camera.resolution[1], self.camera.resolution[0], 4))
            b = np.flipud(b)
            c = cv2.resize(b,(1080,1920), interpolation=cv2.INTER_LINEAR)
            if(self.var):
                a = imagefilter(c)
            else:
                a = c
            texture = Texture.create(size=(a.shape[1], a.shape[0]), colorfmt='rgba')
            texture.blit_buffer(a.tostring(), bufferfmt='ubyte', colorfmt="rgba")
            texture.flip_vertical()
            self.canvas.clear()
            with self.canvas:
                Rectangle(texture=texture, size=(a.shape[1], a.shape[0]),pos=(self.xpos,self.ypos))
                Rectangle(texture=texture, size=(a.shape[1], a.shape[0]),pos=(self.xpos+self.disparity,self.ypos))

class CamApp(App):
    def build(self):
        self.cam   = KivyCamera(fps=60)
        box_layout = BoxLayout(orientation = 'vertical')
        box_layout.add_widget(self.cam)
        return box_layout
    def on_stop(self):
        #without this, app will not exit even if the window is closed
        pass


if __name__ == '__main__':
    CamApp().run()