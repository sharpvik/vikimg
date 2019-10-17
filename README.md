# VikImg Image Utility

Basically, I thought it would be fun to develop my own image encoding. However,
this, by itself is quite meaningless as no one would ever be able to use it
since there would be no software that encodes, decodes, and renders images that
use my encoding.

Thus, I am creating the whole software suite myself. You are welcome. There are
many reasons that make me think that this project is fun:

1. IT'S MY OWN FREAKING IMAGE FORMAT! DO YOU HAVE ONE??? DON'T THINK SO.
2. Can be used as a weak image encriptor as it isn't that popular.
3. It will help me advance in imaging and all that stuff.

It's all about moving bytes in computer memory anyways, so I'm trying to enjoy
it as much as I can.



## Implementation Details

I am not planning to go fancy -- it's a simple RGB based system that uses 3
bytes per pixel -- no alpha chanel, no fancy compression algorithms. At least
for now...

First 8 bytes represent picture's dimentions. They are 4 byte long standard ints
which is more than enough to represent picture's width and height using pixels
as units.

That's it really. Width, height, and the bitmap itself is all there is to it.
The file extention I want to use is `.vimg` which is short for VikImg but is
also kinda symbolic because I am using VIM (editor) to develop it.
