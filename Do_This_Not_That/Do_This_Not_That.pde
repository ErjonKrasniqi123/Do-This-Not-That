//Global Variables
float buttonX1, buttonY1, buttonWidth1, buttonHeight1;
float buttonX2, buttonY2, buttonWidth2, buttonHeight2;
float rectDisplayX, rectDisplayY, rectDisplayWidth, rectDisplayHeight;
float  ellipseDisplayX, ellipseDisplayY, ellipseDisplayXdiameter, ellipseDisplayYdiameter;
color black=#000000;//Nightmode friendly
//
void setup() 
{
  size (600, 400);//Landscape
  println(width, height, displayWidth, displayHeight);
  int appWidth= width;
  int appHeight=height;
  if (width>displayWidth || height>displayHeight) {//CANVAS in Display Checker
    //CANVAS too BIg
    appWidth=displayWidth;
    appHeight=displayHeight;
    println("CANVAS needs to be readjusted to fit on your moniter ");
  } else {
    println("CANVAS  is good to go on your diplay");
  }//End CANVAS in Display Checker
  //Display Orientation
  String ls= "Landscape or Square", p="portrait", DO="Display Orientation", instruct="Bru turn your phun";
  String orientation = (appWidth>=appHeight) ? ls : p; //Ternary Operator, repeats the IF-Else structure to populate a variable
  println(DO, orientation);
  if (orientation==ls) {//Test for choosen Display Orientation
  println("Good to go");
  } else {
    appWidth *= 0;//assignment operator, works like appWidth=appWidth*0
    appHeight *= 0;
    println(instruct);
  };
  //
  //Population using appWidth and appHeight
  int centerX = appWidth*1/2;
  int centerY = appHeight*1/2;
  buttonX1 = centerX - appWidth*1/4;
  buttonY1 = centerY + appHeight*1/4;
  buttonWidth1 = appWidth*1/4;
  buttonHeight1 = appHeight*1/4;
  buttonX2 = centerX + appWidth*1/4;;
  buttonY2 = buttonY1;
  buttonWidth2 = buttonWidth1;
  buttonHeight2 = buttonHeight1;
  rectDisplayX = buttonX1;
  rectDisplayY = centerY - appHeight*1/4;;
  rectDisplayWidth = buttonWidth1;
  rectDisplayHeight = buttonHeight1;
  ellipseDisplayX = buttonX2;
  ellipseDisplayY = rectDisplayY;
  ellipseDisplayXdiameter = appWidth*1/5;
  ellipseDisplayYdiameter = appHeight*1/10;
};//End setup
//
void draw() 
{
  background(black);
  rect(buttonX1,buttonY1, buttonWidth1, buttonHeight1);
  rect(buttonX2, buttonY2, buttonWidth2, buttonHeight2);
  rect(rectDisplayX, rectDisplayY, rectDisplayWidth, rectDisplayHeight );//Button 1
  ellipse( ellipseDisplayX, ellipseDisplayY, ellipseDisplayXdiameter, ellipseDisplayYdiameter);//Button 2
  //
  //Text for Buttons
  
};// End draw
//
void keyPressed() {
};//End keyPressed
//
void mousePressed() {
};//End mouse Pressed
//
