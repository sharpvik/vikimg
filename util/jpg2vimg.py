#!/usr/bin/python3

"""
Image MUST be of JPEG format and contain colour. Otherwise the whole thing goes
down to ashes and fails. I know what I'm talking about... I shed many tears
trying to understand why the heck it's not doing what it's supposed to.
"""

from PIL import Image
import sys


def main(img_filename):
    img = Image.open(img_filename + '.jpg', 'r')
    img_width_bytes = (img.size[0]).to_bytes(4, 'big')
    img_height_bytes = (img.size[1]).to_bytes(4, 'big')
    px_vals_bytes = bytes([p for tups in list( img.getdata() ) for p in tups])

    with open(img_filename + '.vimg', 'wb') as out:
        out.write(img_width_bytes)
        out.write(img_height_bytes)
        out.write(px_vals_bytes)


if __name__ == '__main__':
    main(sys.argv[1])

