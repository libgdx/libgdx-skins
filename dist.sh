#!/bin/bash

rm -r dist
mkdir dist
mkdir dist/skin-previews

for skin in skins/*; do
    echo $skin
    filename=$(basename "$skin")
    cp skins/${filename}/preview.jpg dist/skin-previews/${filename}-preview.jpg
    zip -rj dist/${filename}.zip skins/${filename}/assets/
done
