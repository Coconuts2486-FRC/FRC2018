#include <Joystick.h>

Joystick_ Joystick;

void setup()
{
  Serial.begin(9600);

  for(int i = 0; i < 14; i++)
  {
    pinMode(i, INPUT);
  }
  
  Joystick.begin(true);
}

void loop()
{
  for(int i = 0; i < 14; i++)
  {
    Joystick.setButton(i, digitalRead(i));
  }
  Joystick.setXAxis(analogRead(A0));
  Joystick.setYAxis(analogRead(A1));
  Joystick.setZAxis(analogRead(A2));
  Joystick.setRxAxis(analogRead(A3));
  Joystick.setRyAxis(analogRead(A4));
  Joystick.setRzAxis(analogRead(A5));
}

//void printData()
//{
//  Serial.println("Digital States");
//  for(int i = 0; i < 14; i++)
//  {
//    Serial.println(" - D" + i + ": " + digitalRead(i));
//  }
//  Serial.println("Analog States");
//  for(int i = 0; i < 6; i++)
//  {
//    //Serial.println(" - A" + i + ": " + analogRead(A0));
//  }
//  Serial.println("");
//}

