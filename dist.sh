rm -r dist
mkdir dist
mkdir dist/skin-previews

for skin in skins/*; do
    filename=$(basename "$skin")
    cp skins/${filename}/preview.png dist/skin-previews/${filename}-preview.png
    zip -rj dist/${filename}.zip skins/${filename}/assets/
done
