# This Python file uses the following encoding: utf-8
#importaciones
import os, sys
from Tkinter import * # Importa el módulo
from Estudiante import Estudiante


#Instancia de objetos principales
Est = Estudiante()

#eventos de los botones
def imprimir():
	btnHuella = Button(VentanaEst, text='Leer Huella',width=25,height=9,bg='green',fg='white', state=NORMAL).place(x=530,y=150)

VentanaEst = Tk() # Tk() Es la ventana principal
VentanaEst.title("Gestion Estudiantes")
VentanaEst.config(bg="black") # Le da color al fondo
VentanaEst.geometry("850x500") # Cambia el tamaño de la ventana
VentanaEst.resizable(0,0)

#Elementos del formulario
GestEstudiantes = Label(VentanaEst, text="Gestion Estudiantes",width=20,font=("bold", 20))
GestEstudiantes.place(x=230,y=53)

lblcodigo = Label(VentanaEst, text="Codigo",width=20,font=("bold", 10))
lblcodigo.place(x=70,y=130)
txtCodigo = Entry(VentanaEst)
txtCodigo.place(x=240,y=130)

lblCarrera = Label(VentanaEst, text="Carrera",width=20,font=("bold", 10))
lblCarrera.place(x=70,y=180)
txtCarrera = Entry(VentanaEst)
txtCarrera.place(x=240,y=180)

lblNombres = Label(VentanaEst, text="Nombres",width=20,font=("bold", 10))
lblNombres.place(x=70,y=230)
txtNombres = Entry(VentanaEst)
txtNombres.place(x=240,y=230)

lblApellidos = Label(VentanaEst, text="Apellidos",width=20,font=("bold", 10))
lblApellidos.place(x=70,y=280)
txtApellidos = Entry(VentanaEst)
txtApellidos.place(x=240,y=280)

lblCorreo = Label(VentanaEst, text="Correo",width=20,font=("bold", 10))
lblCorreo.place(x=70,y=330)
txtCorreo = Entry(VentanaEst)
txtCorreo.place(x=240,y=330)

Button(VentanaEst, text='Crear usuario',width=20,bg='green',fg='white', command = imprimir).place(x=70,y=380)
Button(VentanaEst, text='Buscar usuario',width=20,bg='green',fg='white').place(x=300,y=380)
btnHuella = Button(VentanaEst, text='Leer Huella',width=25,height=9,bg='green',fg='white', state=DISABLED).place(x=530,y=150)


VentanaEst.mainloop()
