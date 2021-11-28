#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<conio.h>


/*se declara la estructura para almacenar los datos*/
struct empleados{
	char cedula[10], nombre[50];
	float sueldo;
	int dias;
}data;

FILE *pa;

/*se declara el modulo que permitira abrir el archivo*/
void abrir(int modo){
	if(modo == 1)
		pa = fopen("datos.txt","a+");
	else
		pa = fopen("datos.txt","r");
	if(pa == NULL){
		printf("Error con el Archivo Datos.txt");
		exit(1);
	}
}/*cierre del modulo abrir*/

void cerrar(){
	fcloseall();
}

void guardar(){
	fwrite(&data,sizeof(data),1,pa);
}

int leer(){
	return(fread(&data,sizeof(data),1,pa));
}

/*se declara el modulo que permitira ingresar los datos en el archivo*/
void ingresar(){
	abrir(1);
	clrscr();
	printf("\nIngrese Cedula del Empleado:\n\t");
	gets(data.cedula);
	printf("\nIngrese Nombre y Apellido del Empleado:\n\t");
	gets(data.nombre);
	printf("\nIngrese Sueldo Diario:\n\t");
	scanf("%f",&data.sueldo);
	printf("\nIngrese Cantidad de Dias Trabajados por el Empleado:\n\t");
	scanf("%d",&data.dias);

	guardar();
	cerrar();
}/*cierre del modulo ingresar*/

/*se declara el modulo que permitira mostrar los datos almacenados*/
void mostrar(){
	char cedula[10];
	float cobro = 0;
	abrir(0);
	clrscr();
	printf("\nCedula del Empleado\n\t");
	gets(cedula);
	while(!feof(pa)){
		if(leer()!=0)
			if(strcmp(data.cedula,cedula)==0){
				printf("\nCedula: %s\n\t",data.cedula);
				printf("\nEmpleado: %s\n\t",data.nombre);
				printf("\nDias Trabajados: %d\n A Razon de BsF %.2f\n\t",data.dias,data.sueldo);
				cobro = data.sueldo * data.dias;
				printf("\nEl Sueldo a Cobrar por el Empleado es de%.2f BsF:\n\t",cobro);
				}
			}
	cerrar();
	getch();
}/*cierre del modulo mostrar*/

/*se declara el moduloque permitira listar los datos almacenados*/
void listar(){
	float acum = 0, cobro = 0;
	int cont = 0;
	clrscr();
	abrir(0);
	while(!feof(pa)){
			if(leer()!=0){
				printf("\nCedula :%s\n\t",data.cedula);
				printf("\nNombre y Apellido del Empleado :%s\n\t",data.nombre);
				printf("\nTrabajo %d Dias\nA Razon de BsF.%2f por Dia:\n\t",data.dias,data.sueldo);
				cobro = data.sueldo * data.dias;
				printf("\nEl Sueldo a Cobrar por el Empleado es de%.2f BsF:\n\t",cobro);
				acum = acum + cobro;
				cont ++;
				} /*cierre del if*/
	}/*cierre del ciclo while*/
				printf("\nEl Total de la Nomina es de BsF: %.2f\n\t",acum);
				printf("\nEl Total de Empleados  es de:%d\n\t",cont);

				cerrar();
				getch();
}/*cierre del modulo listar*/

/*se declara el modulo que permitira eliminar registros del archivo*/
void eliminar(){
	char cedula[10];
	FILE *aux;
	aux = fopen("temp.txt","a+");
	abrir(0);
	clrscr();
	printf("\nIngrese Cedula del Empleado a ser Eliminado\n\t");
	gets(cedula);
	while(!feof(pa)){
		if(leer()!=0)
			if(strcmp(data.cedula,cedula)!=0){
				fwrite(&data,sizeof(data),1,aux);
				}
	}/*cierre del ciclo while*/
	printf("\nOperacion Completada\n\t");
	remove("datos.txt");
	rename("temp.txt","datos.txt");
	cerrar();
	getch();
}/*cierre del modulo eliminar*/

/*se declara el modulo menu*/
void menu(){
	int opcion;
		while(1){
			clrscr();
				printf("\n 1.- Ingresar Datos del Empleado\n\t");
				printf("\n 2.- Mostrar Datos del Empleado\n\t");
				printf("\n 3.- Mostrar Nomina General\n\t");
				printf("\n 4.- Eliminar Empleado\n\t");
				printf("\n 5.- Salida\n\t");
	scanf("%d",&opcion);
	getchar();
		if (opcion == 1) ingresar();
		if (opcion == 2) listar();
		if (opcion == 3) mostrar();
		if (opcion == 4) eliminar();
		if (opcion == 5) exit(0);
      }/*cierre del ciclo while*/
}/*cierre del modulo menu*/

void main(){
	menu();
}/*cierre del modulo main*/


