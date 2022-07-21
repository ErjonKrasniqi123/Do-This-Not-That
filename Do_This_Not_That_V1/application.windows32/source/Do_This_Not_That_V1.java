import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Do_This_Not_That_V1 extends PApplet {

//Global Variables
float buttonX1, buttonY1, buttonWidth1, buttonHeight1;
float buttonX2, buttonY2, buttonWidth2, buttonHeight2;
float rectDisplayX, rectDisplayY, rectDisplayWidth, rectDisplayHeight;
float  ellipseDisplayX, ellipseDisplayY, ellipseDisplayXdiameter, ellipseDisplayYdiameter;
int black=0xff000000, white=0xffFFFFFF;//Nightmode friendly
Boolean rectOn=false, ellipseON=false;
//
String buttonText1= "Click Me";
String buttonText2= "Or Me";
PFont buttonFont;
int purple = 0xff2C08FF; //Note Night Mode Friendly, all of the blue is included
public void setup() 
{
  //Landscape
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
  //
  //Text Setup
  //String[] fontList = PFont.list(); //To list all fonts available on system
  println("Start of Console");
  //printArray(fontList); //For listing all possible fonts to choose, then createFont
  buttonFont = createFont ("Harrington", 55); //Must also Tools / Create Font / Find Font / Do Not Press "OK"
};//End setup
//
public void draw() 
{
  background(black);
  rect(buttonX1,buttonY1, buttonWidth1, buttonHeight1);
  rect(buttonX2, buttonY2, buttonWidth2, buttonHeight2);
  if (rectOn==true)rect(rectDisplayX, rectDisplayY, rectDisplayWidth, rectDisplayHeight );//Button 1
  if (ellipseON==true)ellipse( ellipseDisplayX, ellipseDisplayY, ellipseDisplayXdiameter, ellipseDisplayYdiameter);//Button 2
  //
  //Text Draw, General Code for any text
  //Note: visualization rectangle is in main program
  fill(purple); //Ink, hexidecimal copied from Color Selector
  textAlign (CENTER, CENTER); //Align X&Y, see Processing.org / Reference
  //Values: [LEFT | CENTER | RIGHT] & [TOP | CENTER | BOTTOM | BASELINE]
  textFont(buttonFont, 25); //Change the number until it fits, largest font size
  //
  //Specific Text per button
  text(buttonText1,buttonX1,buttonY1, buttonWidth1, buttonHeight1);
  text(buttonText2,buttonX2,buttonY2, buttonWidth2, buttonHeight2);
  fill(white);//Will change the fill() on all shapes the second time repeted in draw()
  //
};// End draw
//
public void keyPressed() {
};//End keyPressed
//
public void mousePressed() {
  rectOn=false;
  ellipseON=false;
  if(mouseX> buttonX1 && mouseX< buttonX1+buttonWidth1 &&mouseY> buttonY1 && mouseY< buttonY1+buttonHeight1 )rectOn=true;
  if(mouseX> buttonX2 && mouseX< buttonX2+buttonWidth2 &&mouseY> buttonY2 && mouseY< buttonY2+buttonHeight2 )ellipseON=true;
};//End mouse Pressed
//
//End Main Program
  public void settings() {  size (600, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Do_This_Not_That_V1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
