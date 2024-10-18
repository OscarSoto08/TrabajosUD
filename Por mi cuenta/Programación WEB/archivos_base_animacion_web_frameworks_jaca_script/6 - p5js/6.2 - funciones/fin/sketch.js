var x = 200;
var y = 200;
var img;  

function setup() {
  createCanvas(800,500);
  stroke("#666666"); 
  fill("#4FBDF2");
  img = loadImage("logo.png"); 
}

function draw() {
  background("#4AF2A1");
  //clear();
  
  //rect(50,50,75,100);
  rect(x/2,y/2,75,100);
  //ellipse(250, 150, 80, 80);
  ellipse(x, y, 80, 80);

  x++;
  y++;
  
  triangle(230, 275, 258, 220, 286, 275);

  //image(img, 350, 200, 100, 100);
  image(img, x, 200, 100);
  
}