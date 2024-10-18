var x = 100;
var y = 100;

function setup() {
  createCanvas(800,500);
}

function draw() {
  clear();
  ellipse(x, height/2, 120, 120);
  x++;
}