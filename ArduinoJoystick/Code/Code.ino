#include <Joystick.h>
#include "FastLED.h"

#define COLOR_ORDER GRB
#define MAX_BRIGHTNESS 255
#define NUM_LEDS 150
#define DATA_PIN 11

CRGB leds[NUM_LEDS];

Joystick_ Joystick;

void setup()
{
  Serial.begin(9600);

  for (int i = 0; i < 14; i++)
  {
    pinMode(i, INPUT);
  }

  Joystick.begin(true);

  FastLED.addLeds<WS2812B, DATA_PIN, COLOR_ORDER>(leds, NUM_LEDS);
  FastLED.clear();
  FastLED.show();
  delay(250);
  //clear() turns all LEDs off
  FastLED.clear();
  FastLED.setBrightness(MAX_BRIGHTNESS);
  fill_solid( leds, NUM_LEDS /*number of leds*/, CRGB( 125, 125, 125) );
  FastLED.show();
}

void loop()
{
  for (int i = 0; i < 14; i++)
  {
    Joystick.setButton(i, digitalRead(i));
  }
  Joystick.setXAxis(analogRead(A0));
  Joystick.setYAxis(analogRead(A1));
  Joystick.setZAxis(analogRead(A2));
  Joystick.setRxAxis(analogRead(A3));
  Joystick.setRyAxis(analogRead(A4));
  Joystick.setRzAxis(analogRead(A5));

  FastLED.clear();
  FastLED.show();
  delay(500);
  //CSK 3/20/2014 I added a rainbow function just for grins
  rainbow(1);
  cylon(CRGB::Red, 1, 1);
  cylon(CRGB::Green, 1, 1);
  cylon(CRGB::Blue, 1, 1);
  color_chase(CRGB::Red, 5);
  color_chase(CRGB::DarkOrange, 5);
  color_chase(CRGB::Yellow, 5);
  color_chase(CRGB::Green, 5);
  color_chase(CRGB::Blue, 5);
  color_chase(CRGB::Violet, 5);
  missing_dot_chase(CRGB::White, 5);
  missing_dot_chase(CRGB::Red, 5);
  missing_dot_chase(CRGB::Yellow, 5);
  missing_dot_chase(CRGB::Green, 5);
  missing_dot_chase(CRGB::Cyan, 5);
  missing_dot_chase(CRGB::Blue, 5);
  missing_dot_chase(0x3000cc, 5) ;
}

void color_chase(uint32_t color, uint8_t wait)
{
  FastLED.clear();
  //The brightness ranges from 0-255
  //Sets brightness for all LEDS at once
  FastLED.setBrightness(MAX_BRIGHTNESS);
  // Move a block of LEDs

  for (int led_number = 0; led_number < NUM_LEDS - 5; led_number++)
  {
    // Turn our current led ON, then show the leds
    leds[led_number] = color;
    //CSK 4/22/2016 Make it multiple dots on
    leds[led_number + 1] = color;
    leds[led_number + 2] = color;
    leds[led_number + 3] = color;
    leds[led_number + 4] = color;
    leds[led_number + 5] = color;
    // Show the leds (only one of which is has a color set, from above
    // Show turns actually turns on the LEDs
    FastLED.show();
    // Wait a little bit
    delay(wait);
    // Turn our current led back to black for the next loop around
    //CSK 4/22/2016 Turn the dots off
    leds[led_number] = CRGB::Black;
  }
  return;
}
//Move an "empty" dot down the strip
void missing_dot_chase(uint32_t color, uint8_t wait)
{
  //Step thru some brightness levels from max to 10. led_brightness/=2 is a cryptic shorthand way of saying
  led_brightness = led_brightness / 2
                   // for (int led_brightness = MAX_BRIGHTNESS; led_brightness > 10; led_brightness/=2)
  {
    //FastLED.setBrightness(led_brightness);
    //CSK 4/22/2016 Turn brightness down to save batteries since almost all leds are on
    FastLED.setBrightness(25);
    // Start by turning all pixels on:
    //for(int led_number = 0; led_number < NUM_LEDS; led_number++) leds[led_number] = color;
    //https://github.com/FastLED/FastLED/wiki/Controlling-leds
    fill_solid(leds, NUM_LEDS, color);
    // Then display one pixel at a time:
    for (int led_number = 0; led_number < NUM_LEDS - 5; led_number++)
    {
      leds[led_number] = CRGB::Black; // Set new pixel 'off'
      //CSK 4/22/2016
      leds[led_number + 1] = CRGB::Black; // Set new pixel 'off'
      leds[led_number + 2] = CRGB::Black; // Set new pixel 'off'
      leds[led_number + 3] = CRGB::Black; // Set new pixel 'off'
      leds[led_number + 4] = CRGB::Black; // Set new pixel 'off'
      leds[led_number + 5] = CRGB::Black; // Set new pixel 'off'
      if ( led_number > 0 && led_number < NUM_LEDS)
      {
        leds[led_number - 1] = color; // Set previous pixel 'on'
      }
      FastLED.show();
      delay(wait);
    }
  }
  return;
}
//Cylon - LED sweeps back and forth, with the color, delay and number of cycles of your choice
void cylon(CRGB color, uint16_t wait, uint8_t number_of_cycles)
{
  FastLED.setBrightness(MAX_BRIGHTNESS);
  for (uint8_t times = 0; times <= number_of_cycles; times++)
  {
    // Make it look like one LED is moving in one direction
    for (int led_number = 0; led_number < NUM_LEDS; led_number++)
    {
      //Apply the color that was passed into the function
      leds[led_number] = color;
      //Actually turn on the LED we just set
      FastLED.show();
      // Turn it back off
      leds[led_number] = CRGB::Black;
      // Pause before "going" to next LED
      delay(wait);
    }
    // Now "move" the LED the other direction
    for (int led_number = NUM_LEDS - 1; led_number >= 0; led_number--)
    {
      //Apply the color that was passed into the function
      leds[led_number] = color;
      //Actually turn on the LED we just set
      FastLED.show();
      // Turn it back off
      leds[led_number] = CRGB::Black;
      // Pause before "going" to next LED
      delay(wait);
    }
  }
  return;
}
void rainbow(uint8_t wait)
{
  uint16_t hue;
  FastLED.clear();
  for (hue = 10; hue < 255 * 3; hue++)
  {
    fill_rainbow( &(leds[0]), NUM_LEDS /*led count*/, hue /*starting hue*/);
    FastLED.show();
    delay(wait);
  }
  return;
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

