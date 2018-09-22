//librerias de uso
#include <Adafruit_Fingerprint.h>
#include <SoftwareSerial.h>

//definimos los pines del sensor
SoftwareSerial mySerial(2, 3);
Adafruit_Fingerprint finger = Adafruit_Fingerprint(&mySerial);

uint8_t id;

void setup() {
  //inicializamos el puerto serial
  Serial.begin(9600);
  while (!Serial);  // For Yun/Leo/Micro/Zero/...
  delay(100);
  Serial.println("Bienvenido a descifratek");

  //configuramos la velocidad del sensor
  finger.begin(57600);

  //verificamos si hay sensores conectados
  if (finger.verifyPassword()) {
    Serial.println("Sensor encontrado!");
  } else {
    Serial.println("No se encontro el sensor");
    while (1) { delay(1); }
  }

}

uint8_t readnumber(void) {
  uint8_t num = 0;
  
  while (num == 0) {
    while (! Serial.available());
    num = Serial.parseInt();
  }
  return num;
}

uint8_t getFingerprintEnroll() {

  int p = -1;
  while (p != FINGERPRINT_OK) {
    p = finger.getImage();
    switch (p) {
    case FINGERPRINT_OK:
      break;
    case FINGERPRINT_NOFINGER:
      break;
    case FINGERPRINT_PACKETRECIEVEERR:
      Serial.println("Error comunicacion");
      break;
    case FINGERPRINT_IMAGEFAIL:
      Serial.println("Error Imagen");
      break;
    default:
      Serial.println("Error desconocido");
      break;
    }
  }

  // OK success!

  p = finger.image2Tz(1);
  switch (p) {
    case FINGERPRINT_OK:
      Serial.println("Huella1 tomada");
      break;
    case FINGERPRINT_IMAGEMESS:
      Serial.println("Imagen desordenada");
      return p;
    case FINGERPRINT_PACKETRECIEVEERR:
      Serial.println("Error comunicacion");
      return p;
    case FINGERPRINT_FEATUREFAIL:
      Serial.println("Cno se pudo encontrar las caracteristicas de la huella");
      return p;
    case FINGERPRINT_INVALIDIMAGE:
      Serial.println("no se pudo encontrar las caracteristicas de la huella");
      return p;
    default:
      Serial.println("Error desconocido");
      return p;
  }
  

  delay(2000);
  p = 0;
  while (p != FINGERPRINT_NOFINGER) {
    p = finger.getImage();
  }
  p = -1;
  while (p != FINGERPRINT_OK) {
    p = finger.getImage();
    switch (p) {
    case FINGERPRINT_OK:
      break;
    case FINGERPRINT_NOFINGER:
      break;
    case FINGERPRINT_PACKETRECIEVEERR:
      Serial.println("Error comunicacion");
      break;
    case FINGERPRINT_IMAGEFAIL:
      Serial.println("IError de imagen");
      break;
    default:
      Serial.println("Error desconocido");
      break;
    }
  }

  // OK success!

  p = finger.image2Tz(2);
  switch (p) {
    case FINGERPRINT_OK:
      Serial.println("Huella2 tomada");
      break;
    case FINGERPRINT_IMAGEMESS:
      Serial.println("Imagen desordenada");
      return p;
    case FINGERPRINT_PACKETRECIEVEERR:
      Serial.println("Error comunicacion");
      return p;
    case FINGERPRINT_FEATUREFAIL:
      Serial.println("Cno se pudo encontrar las caracteristicas de la huella");
      return p;
    case FINGERPRINT_INVALIDIMAGE:
      Serial.println("no se pudo encontrar las caracteristicas de la huella");
      return p;
    default:
      Serial.println("Error desconocido");
      return p;
  }
  
  
  p = finger.createModel();
  if (p == FINGERPRINT_OK) {
  } else if (p == FINGERPRINT_PACKETRECIEVEERR) {
    Serial.println("Error comunicacion");
    return p;
  } else if (p == FINGERPRINT_ENROLLMISMATCH) {
    Serial.println("No emparejo las huellas");
    return p;
  } else {
    Serial.println("Error desconocido");
    return p;
  }   
  
  p = finger.storeModel(id);
  if (p == FINGERPRINT_OK) {
    Serial.println("Huella guardada");
  } else if (p == FINGERPRINT_PACKETRECIEVEERR) {
    Serial.println("Error comunicacion");
    return p;
  } else if (p == FINGERPRINT_BADLOCATION) {
    Serial.println("No pudo ser guardado en la ubicacion");
    return p;
  } else if (p == FINGERPRINT_FLASHERR) {
    Serial.println("Error escribiendo en memoria");
    return p;
  } else {
    Serial.println("Error desconocido");
    return p;
  }   
}

void loop() {
 
  id = readnumber();
  if (id == 0) {// 
     return;
  }
  
  while (!  getFingerprintEnroll() );
}
