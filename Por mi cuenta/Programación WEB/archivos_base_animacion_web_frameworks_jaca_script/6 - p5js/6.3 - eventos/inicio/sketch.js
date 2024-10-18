var x = 100;
var y = 100;
var img;

function setup() {
    createCanvas(800, 500);
    stroke("#666666");
    fill("#4FBDF2");
    img = loadImage("logo.png");
}

function draw() {
    background("#4AF2A1");

    ellipse(x, y, 200, 200);

    //image(img, mouseX, mouseY);

    //mousePresionado() 

    moverCirculo()
}

function mousePresionado() {
    if (mouseIsPressed) {
        fill("#1B354B");
    } else {
        fill("#F6D030");
    }
}

function moverCirculo(){
	if (keyIsDown(LEFT_ARROW))
	    x-=5;

	  if (keyIsDown(RIGHT_ARROW))
	    x+=5;

	  if (keyIsDown(UP_ARROW))
	    y-=5;

	  if (keyIsDown(DOWN_ARROW))
	    y+=5;
}
