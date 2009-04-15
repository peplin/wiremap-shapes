import wiremap.Wiremap;
import wiremap.WiremapGlowingSphere;

Wiremap map;
WiremapGlowingSphere glowingSphere;

void setup() {
    size(1024, 768, P3D);

    map = new Wiremap(this, 256, 90, 36, 36, 48, .1875, .1875, 4,
            "depth256.txt");

    glowingSphere = new WiremapGlowingSphere(
            map, 500, 300, 10, color(255, 255, 0), 10, 
            color(255, 0, 0)); 
}

void draw() {
    background(0);
   
    glowingSphere.setPosition(mouseX, 300, map(mouseY, 0, 768, 0, 36));
    glowingSphere.display();
}

