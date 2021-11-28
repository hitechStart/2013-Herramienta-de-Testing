//
//
//
//
//Autor: Isaias Duque Gomez
//Descripcion: Archivos Secuenciales Binarios
//Cualquier duda, comentario, criticas si deseas escribir no du
//isaias_duque_gomez@yahoo.com.mx , con gusto te atender‚
//Funcionamiento: Entras a la seccion CREAR, el archivo se crea en C: de tal manera
//que se pueda escribir en el, si deseas puedes borrar los datos que contiene desde ahi
//etc.
//
//
//
//

#include<graphics.h>
#include<string.h>
#include<dos.h>
#include<ctype.h>
#include<math.h>
#include<process.h>
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<io.h>

#define COLOR BLUE   //cambia el color a tu agrado desde aqui
/************************************************************************/
//ESTRUCTURA
//
	struct datos
		{
		char nom[20];     	//nombre
		char ap[20];     	//apellido paterno
		char am[20];     	//apellido materno
		char fnac[20];		//fecha de nacimiento
		char tpart[20]; 	//telefono particular
		char cel[20]; 		//telefono celular
		int baja;           //estado
		}agenda;            //tipo de dato
//DECLARACION DE FUNCIONES

	void inicio_grafico();
	void crea();
	void altas();
	void listado();
	void consulta();
	void modifica();
	void elimina();
	void recupera();
	void caja_texto();
	void centra(int fila,char *texto);
	void boton(int x1,int y1,int x2,int y2,int e,char *n,int color);
	char *letras_todas(int x,int y);
	int Existe_Archivo(char *Archivo);
	int Abrir_Archivo(char*Archivo,char*tipo);

/************************************************************************/
//FUNCION PRINCIPAL
//
	void main()
		{char tecla;
		inicio_grafico();     //inicia el ambiente grafico
		do
			{  ///Menuu de seleccion
			cleardevice();
			setfillstyle(1,BLACK);
			bar(getmaxx(),getmaxy(),0,0);
			settextstyle(2,0,5);
			centra(50,"MENU PRINCIPAL");//
			settextstyle(2,0,4);
			//boton de crear
			boton(160,100,295,130,0,"1.CREAR",COLOR);//
			//boton de altas
            boton(160,150,295,180,0,"2.ALTAS",COLOR);//
			//boton de consulta general
            boton(160,200,295,230,0,"3.CONSULTA GENERAL",COLOR);//
			//boton de consulta individual
            boton(160,250,295,280,0,"4.CONSULTA INDIVIDUAL",COLOR);//
			//boton para modificar
            boton(325,100,460,130,0,"5.MODIFICAR",COLOR);//
			//boton para elmininaar
            boton(325,150,460,180,0,"6.ELIMINAR",COLOR);//
			//boton para recuperar
            boton(325,200,460,230,0,"7.RECUPERAR",COLOR);//
			//boton para salir
            boton(325,250,460,280,0,"8.SALIR",COLOR);//
			outtextxy(210,420,"ELIGE UNA OPCION ");//
			setfillstyle(1,COLOR);
			bar(0,400,getmaxx(),getmaxy());
			centra(430,"AGENDA ELECTRONICA");//
			centra(440,"by isaias");//
			line(0,400,getmaxx(),400);
			tecla=getch();
			switch(tecla)
				{case '1': crea();  break;
				case '2': altas(); 	   break;
				case '3': listado();break;
				case '4': consulta();break;
				case '5': modifica(); break;
				case '6': elimina(); break;
				case '7': recupera(); break;
				case '8': break;
				default:  caja_texto();break;;}
			}
		while(tecla!='8');
		}//
/************************************************************************/
//CREA EL ARCHIVO
       void crea()
		{ //Esta fuencion
        //es para la creacion
        //del archivo donde se guardaran
        //los contactos
		char opc;
		FILE *archivo;
		cleardevice();
		centra(30,"CREACION DEL ARCHIVO");//
		setfillstyle(1,COLOR);
		bar(0,400,getmaxx(),getmaxy());
		centra(430,"AGENDA ELECTRONICA");//
		line(0,400,getmaxx(),400);
		if(Existe_Archivo("C:\\AGENDA.dat")==1) //Si existe
			{outtextxy(220,100,"El archivo ya existe, ¨Deseas?");//
			outtextxy(200,130,"Abrir y a¤adir datos (r+b)...............1");//
			outtextxy(200,150,"Empezar de nuevo     (w+b)..............2");//
			outtextxy(200,170,"Exit...............................................3");//
			outtextxy(200,200,"Opcion..........................................[ ]\b\b");//
			opc=getch();
			if(opc=='1')
				{
				if(Abrir_Archivo("C:\\AGENDA.dat","r+b")==1)return; //
					{centra(300,"El archivo se abrira para a¤adir..");//
					getch();}
				}
			if(opc=='2')
				{
				if(Abrir_Archivo("C:\\AGENDA.dat","w+b")==1) return; //
					{centra(300,"El archivo se abrira para empezar..");//
					getch();
					return; //
					}
				}
			if(opc=='3')
				{centra(300,"Se detuvo la accion..");//
				getch();
				return; //
				}
			}
		else
			{
			if(Abrir_Archivo("C:\\AGENDA.dat","w+b")==1) return; //
				{centra(300,"El archivo se creo para a¤adir..");//
				getch();
				return; //
				}
			}
		fclose(archivo); //cerrando el archivo
		}//
/************************************************************************/
//DA DE ALTAS REGISTROS
	void altas()
		{// Esta funcion
        // es para realizar
        // altas de contactos
        // declarando variables
		char aux[20]="";
		int band=0;
		FILE *archivo;
		cleardevice();
		centra(30,"INGRESA DATOS");//
		setfillstyle(1,COLOR);
		bar(0,400,getmaxx(),getmaxy());
		centra(430,"AGENDA ELECTRONICA");//
		line(0,400,getmaxx(),400);
		archivo=fopen("C:\\AGENDA.dat","r+b"); 	//se abre el archivo
		if(archivo==NULL)
			{centra(getmaxy()/2,"EL ARCHIVO NO SE ENCUENTRA"); } // el archivo no existe
		else
			{outtextxy(30,90,"NOMBRE: ");//
			outtextxy(150,90,strcpy(aux,letras_todas(150,90))); //guarda el nombre para buscarlo en el archivo
			do
				{
				fread(&agenda,sizeof(agenda),1,archivo); //leyendo el archivo
				//se valida que la persona no exista
				//comparando el nombre
                //si existe no se guarda
				if(agenda.baja==1 && strcmp(aux,agenda.nom)==0)
					{band=1;
					centra(250,"YA SE ENCUENTRA ESA PERSONA");//
					break;} //
				}
			while(!feof(archivo));
			if(!band) 
				{ //la persona no estaba
				strcpy(agenda.nom,aux);// guardan todos los datos
				outtextxy(30,105,"APELLIDO PATERNO: ");//
				outtextxy(150,105,strcpy(agenda.ap,letras_todas(150,105)));
				outtextxy(30,120,"APELLIDO MATERNO: ");//
				outtextxy(150,120,strcpy(agenda.am,letras_todas(150,120)));
				outtextxy(30,135,"F. DE NACIMIENTO: ");//
				outtextxy(150,135,strcpy(agenda.fnac,letras_todas(150,135)));
				outtextxy(30,150,"TEL PARTICULAR: ");//
				outtextxy(150,150,strcpy(agenda.tpart,letras_todas(150,150)));
				outtextxy(30,165,"TEL CELULAR: ");//
				outtextxy(150,165,strcpy(agenda.cel,letras_todas(150,165)));
				agenda.baja=1;
				fwrite(&agenda,sizeof(agenda),1,archivo); //escribiendo el archivo
				outtextxy(230,250,"Acabas de dar de alta los datos ");//
				}
			}
		fclose(archivo); //cerrando el archivo
		getch();}
/************************************************************************/
//CONSULTA GRAL
	void listado()
		{//Esta funcion es para enlistar
        // los contactos
		int band=0,f=80;
		FILE *archivo;
		cleardevice();
		centra(30,"CONSULTA GENERAL");//
		setfillstyle(1,COLOR);
		bar(0,400,getmaxx(),getmaxy());
		centra(430,"AGENDA ELECTRONICA");//
		line(0,400,getmaxx(),400);
		archivo=fopen("C:\\AGENDA.dat","rb"); //se abre el archivo
		if(archivo==NULL)
			{centra((getmaxy()/2)-20,"NO SE ENCUENTRA EL ARCHIVO"); } //el archivo no existe
		else
			{
			do
				{
				fread(&agenda,sizeof(agenda),1,archivo); //leyendo el archivo
				if(agenda.baja==1 && !feof(archivo))
					{band=1;
					setcolor(COLOR);
					outtextxy(20,60,"NOMBRE");//
					outtextxy(100,60,"APELLIDO PATERNO");//
					outtextxy(220,60,"APELLIDO MATERNO");//
					outtextxy(340,60,"F.NACIMIENTO");//
					outtextxy(440,60,"TEL PARTICULAR");//
					outtextxy(550,60,"TEL CELULAR");//
					setcolor(15);
					outtextxy(20,f,agenda.nom);
					outtextxy(100,f,agenda.ap);
					outtextxy(220,f,agenda.am);
					outtextxy(340,f,agenda.fnac);
					outtextxy(440,f,agenda.tpart);
					outtextxy(550,f,agenda.cel);
					f+=15;}
				}
			while(!feof(archivo));
			if(!band)
				{centra(230,"No Hay Ningun Dato"); }//
			}
		fclose(archivo); //cerrando el archivo
		getch();}
/************************************************************************/
//CONSULTA INDIVIDUAL
	void consulta()
		{int band=0; //declarando varibales
		char aux[20]="";
		cleardevice();
		centra(30,"CONSULTA INDIVIDUAL");//
		setfillstyle(1,COLOR);
		bar(0,400,getmaxx(),getmaxy());
		centra(430,"AGENDA ELECTRONICA");//
		line(0,400,getmaxx(),400);
		FILE *archivo;
		archivo=fopen("C:\\AGENDA.dat","r+b"); // se abre el archivo
		if(archivo==NULL)
			{ centra(250,"NO SE ENCUENTRA EL ARCHIVO"); } //el archivo no existe
		else
			{outtextxy(30,90,"NOMBRE: ");//
			outtextxy(150,90,strcpy(aux,letras_todas(150,90)));
			do
				{
				fread(&agenda,sizeof(agenda),1,archivo);//leyendo el archivo
				if(strcmp(aux,agenda.nom)==0 && agenda.baja==1)
					{band=1;
					setcolor(15);
					outtextxy(30,120,"APELLIDO PATERNO: ");//
					outtextxy(30,135,"APELLIDO MATERNO: ");//
					outtextxy(30,150,"F.NACIMIENTO: ");//
					outtextxy(30,165,"TEL PARTICULAR: ");//
					outtextxy(30,180,"TEL CELULAR: ");//
					outtextxy(150,120,agenda.ap);
					outtextxy(150,135,agenda.am);
					outtextxy(150,150,agenda.fnac);
					outtextxy(150,165,agenda.tpart);
					outtextxy(150,180,agenda.cel);}
				}
			while(!feof(archivo));
			if(!band)
				{ centra(250,"No Se Encontro Esa Persona");	}//
			}
		fclose(archivo); //cerrando el archivo
		getch();}
/************************************************************************/
//MODIFICA DATOS
	void modifica()
		{ //decalarando variables
		int band=0,cont=0;
		char aux[20]="",opc;
		FILE *archivo;
		cleardevice();
		centra(30,"MODIFICA DATOS");//
		setfillstyle(1,COLOR);
		bar(0,400,getmaxx(),getmaxy());
		centra(430,"AGENDA ELECTRONICA");//
		line(0,400,getmaxx(),400);
		archivo=fopen("C:\\AGENDA.dat","r+b"); //se abre el archivo
		if(archivo==NULL)
			{ centra(250,"NO SE ENCUENTRA EL ARCHIVO");} //no existe el archivo
		else
			{
			outtextxy(30,90,"NOMBRE: ");//
			outtextxy(150,90,strcpy(aux,letras_todas(150,90)));
			do
				{
				fread(&agenda,sizeof(agenda),1,archivo); //leer archivo
				if(strcmp(aux,agenda.nom)==0 && agenda.baja==1) //se busca la persona solicitada
					{band=1;
					outtextxy(30,90,"NOMBRE: ");//
					outtextxy(150,90,agenda.nom);
					outtextxy(30,105,"APELLIDO PATERNO: ");//
					outtextxy(150,105,agenda.ap);
					outtextxy(30,120,"APELLIDO MATERNO: ");//
					outtextxy(150,120,agenda.am);
					outtextxy(30,135,"F.NACIMIENTO: ");//
					outtextxy(150,135,agenda.fnac);
					outtextxy(30,150,"TEL PARTICULAR: ");//
					outtextxy(150,150,agenda.tpart);
					outtextxy(30,165,"TEL CELULAR: ");//
					outtextxy(150,165,agenda.cel);
					break;}//
				cont++;
				}
			while(!feof(archivo));
			if(!band)
				{centra(250,"No Se Encontr¢ Esa Persona");} // la persona no esta
			if(band)
				{centra(250,"¨Deseas modificar? [S/N]"); // confirmacion de la modificacion
				opc=getch();
				if(toupper(opc)=='S')
					{cont=cont*sizeof(agenda);
					fseek(archivo,cont,SEEK_SET);
					cleardevice();
					centra(30,"MODIFICA DATOS");//
					setfillstyle(1,COLOR);
					bar(0,400,getmaxx(),getmaxy());
					centra(430,"AGENDA ELECTRONICA");//
					line(0,400,getmaxx(),400);
					outtextxy(30,90,"NOMBRE: ");//
					outtextxy(150,90,strcpy(agenda.nom,letras_todas(150,90)));
					outtextxy(30,105,"APELLIDO PATERNO: ");//
					outtextxy(150,105,strcpy(agenda.ap,letras_todas(150,105)));
					outtextxy(30,120,"APELLIDO MATERNO: ");//
					outtextxy(150,120,strcpy(agenda.am,letras_todas(150,120)));
					outtextxy(30,135,"F. DE NACIMIENTO: ");//
					outtextxy(150,135,strcpy(agenda.fnac,letras_todas(150,135)));
					outtextxy(30,150,"TEL PARTICULAR: ");//
					outtextxy(150,150,strcpy(agenda.tpart,letras_todas(150,150)));
					outtextxy(30,165,"TEL CELULAR: ");//
					outtextxy(150,165,strcpy(agenda.cel,letras_todas(150,165)));
					centra(360,"Pulsa una tecla para continuar...");//
					fwrite(&agenda,sizeof(agenda),1,archivo); } //escribiendo el archivo
				else
					{ centra(280,"Acabas de Cancelar La Modificacion");	}//
				}
			 }
		fclose(archivo); //cerrando el archivo
		getch(); }
/******************************************************************************/
//ELIMINA DATO
	void elimina()
		{//
		int band=0,cont=0;
		char aux[20]="",opc;
		FILE *archivo;
		cleardevice();
		centra(30,"ELIMINA DATOS");//
		setfillstyle(1,COLOR);
		bar(0,400,getmaxx(),getmaxy());
		centra(430,"AGENDA ELECTRONICA");//
		line(0,400,getmaxx(),400);
		archivo=fopen("C:\\AGENDA.dat","r+b"); //se abre el archivo
		if(archivo==NULL)
			{ centra(250,"NO SE ENCUENTRA EL ARCHIVO");} //no existe el achivo
		else
			{outtextxy(30,90,"NOMBRE: ");//
			outtextxy(150,90,strcpy(aux,letras_todas(150,90)));
			do
				{
				fread(&agenda,sizeof(agenda),1,archivo);
				if(strcmp(aux,agenda.nom)==0 && agenda.baja==1) //se busca la persona a borrar
					{band=1;
					outtextxy(30,90,"NOMBRE: ");//
					outtextxy(150,90,agenda.nom);
					outtextxy(30,105,"APELLIDO PATERNO: ");//
					outtextxy(150,105,agenda.ap);
					outtextxy(30,120,"APELLIDO MATERNO: ");//
					outtextxy(150,120,agenda.am);
					outtextxy(30,135,"F.NACIMIENTO: ");//
					outtextxy(150,135,agenda.fnac);
					outtextxy(30,150,"TEL PARTICULAR: ");//
					outtextxy(150,150,agenda.tpart);
					outtextxy(30,165,"TEL CELULAR: ");//
					outtextxy(150,165,agenda.cel);
					break;} //
				cont++;
				}
			while(!feof(archivo));
			if(!band)
				{centra(250,"No Se Encontr¢ Esa Persona"); 	}//
			if(band)
				{centra(250,"¨Deseas Eliminar? [S/N]"); //confirmacion de la eliminacion
				opc=getch();
				if(toupper(opc)=='S')
					{agenda.baja=0;
					cont=cont*sizeof(agenda);
					fseek(archivo,cont,SEEK_SET);
					centra(350,"Acabas De Elimiar Ese Dato...");//
					fwrite(&agenda,sizeof(agenda),1,archivo); //escribiendo el archivo
					}
				else
					{ centra(250,"Acabas de Cancelar La Baja"); }//
				}
			 }
		fclose(archivo); //cerrando el archivo
		getch();}
/******************************************************************************/
//RECUPERA DATO
	void recupera()
		{//declarando variables
		int band=0,cont=0;
		char aux[20]="",opc;
		FILE *archivo;
		cleardevice();
		centra(30,"RECUPERACION DE DATOS");//
		setfillstyle(1,COLOR);
		bar(0,400,getmaxx(),getmaxy());
		centra(430,"AGENDA ELECTRONICA");//
		line(0,400,getmaxx(),400);
		archivo=fopen("C:\\AGENDA.dat","r+b"); //abre el archivo
		if(archivo==NULL)
			{	centra(250,"NO SE ENCUENTRA EL ARCHIVO"); } // el arhivo no existe
		else
			{outtextxy(30,90,"NOMBRE: ");//
			outtextxy(150,90,strcpy(aux,letras_todas(150,90)));
			do
				{ // se busca en el archivo la persona solicitada
				fread(&agenda,sizeof(agenda),1,archivo);
				if(strcmp(aux,agenda.nom)==0 && agenda.baja==0)
					{band=1;
					outtextxy(30,90,"NOMBRE: ");//
					outtextxy(150,90,agenda.nom);
					outtextxy(30,105,"APELLIDO PATERNO: ");//
					outtextxy(150,105,agenda.ap);
					outtextxy(30,120,"APELLIDO MATERNO: ");//
					outtextxy(150,120,agenda.am);
					outtextxy(30,135,"F.NACIMIENTO: ");//
					outtextxy(150,135,agenda.fnac);
					outtextxy(30,150,"TEL PARTICULAR: ");//
					outtextxy(150,150,agenda.tpart);
					outtextxy(30,165,"TEL CELULAR: ");//
					outtextxy(150,165,agenda.cel);
					break;} //
				cont++;
				}
			while(!feof(archivo));
			if(!band)
				{	centra(250,"No Se Encontr¢ Esa Persona"); }//
			if(band)
				{centra(250,"¨Deseas Recuperarlo? [S/N]"); //confirmacion de la recuperacin
				opc=getch();
				if(toupper(opc)=='S')
					{agenda.baja=1;
					cont=cont*sizeof(agenda);
					fseek(archivo,cont,SEEK_SET);
					centra(350,"Acabas De Recuperar Ese Dato...");//
					fwrite(&agenda,sizeof(agenda),1,archivo);}//escribiendo el archivo
				else
					{ centra(250,"Acabas de Cancelar La Recuperacion"); }//
				}
			 }
		fclose(archivo); //cerrando el archivo
		getch(); }
/******************************************************************************/
	void caja_texto()
		{//
		void *msj;
		unsigned size;
		size=imagesize(185,300,440,330);
		msj=malloc(size);
		getimage(185,300,440,330,msj);
		putimage(185,300,msj,COPY_PUT);
		free(msj);
		boton(185,300,440,330,0,"          !!!OPCION NO VALIDA!!!",RED);//
		delay(800); }//
/*****************************************************************************/
	void centra(int fila,char *texto)
		{	settextstyle(2,0,4);
		outtextxy((640-(strlen(texto)*5))/2,fila,texto); }
/*****************************************************************************/
	int Abrir_Archivo(char*Archivo,char*tipo)
		{FILE *archivo;
		int valor;
		valor=0; //no hay error
		archivo=fopen(Archivo,tipo);  //abre el archivo
		if(archivo==NULL)
			{valor=1;
			outtextxy(230,350,"Error...");//
			getch(); }
		return(valor);}
/************************************************************************/
	int Existe_Archivo(char *Archivo)
		{int existe=0;
		if(access(Archivo,0)==0)
			{existe=1;		}
		return(existe);}
/************************************************************************/
//INCIA AMBIENTE GRAFICO
	void inicio_grafico()
		{ //
		int gdriver = DETECT, gmode, errorcode;  //Detectar automaticamente
		int left, top, right, bottom;
		initgraph (&gdriver, &gmode, "c:\\tc\\bgi");   //Inicia grafico y variable local
		errorcode = graphresult();          //Leer resultado de inicio
		if (errorcode != grOk)           //Si ocurre error
			{printf("Graphics error: %s\n", grapherrormsg(errorcode));//
			printf("Press any key to halt:");//
			getch();
			exit(1);                    //Termina con un error de codigo
			}//
		}//
/*****************************************************************************/
//CAPTURA LETRAS,NUMEROS
	char *letras_todas(int x,int y)             /// FUNCION
		{ char  *arreg;
		int tecla,v=0,i=0;    /// CAPTURA
			///LETRAS
		for (v=0; v<80; v++)
			{
			arreg[v]=0;
			}
		do
			{tecla=getch();
			if((tecla>64 && tecla <91) || (tecla>=97 && tecla <=122) || tecla== 164 || tecla==165 || tecla>=48 && tecla<=58 )
				{arreg[i]=tecla;
				i++;
				outtextxy(x,y,arreg);}
			if(tecla==32)
				{arreg[i]=' ';
				i++;
				outtextxy(x,y,arreg);}
			if(tecla==8)      //agregado
				{setcolor(0);
				outtextxy(x,y,arreg);
				arreg [--i]=0;
				setcolor(WHITE);
				outtextxy(x,y,arreg);}
			if(tecla==46)
				{setcolor(WHITE);
				arreg[i]='.';
				i++;
				outtextxy(x,y,arreg);}
			if(tecla==92)
				{setcolor(WHITE);
				arreg[i]=(92);
				i++;
				outtextxy(x,y,arreg);}
			}while(tecla!=13);
	return (arreg); } //
/*****************************************************************************/
//DIBUJA BOTON
	void boton(int x1,int y1,int x2,int y2,int e,char *n,int color)
		{int x,y;
		setfillstyle(1,color);
		bar(x1,y1,x2,y2);
		x=x1+10;
		y=y1+10;
		outtextxy(x,y,n);
			if(e==0)
				{setcolor(0);
				line(x1,y2,x2,y2);       	//inferior
				line(x1-1,y2+1,x2+1,y2+1);
                //
				line(x2,y2,x2,y1);     		// derecha
				line(x2+1,y2+1,x2+1,y1-1);
                //
				setcolor(15);
				line(x1,y1,x2,y1);  		//superior
				line(x1-1,y1-1,x2+1,y1-1);
                //
				line(x1,y2,x1,y1); 		//izquierda
				line(x1-1,y2+1,x1-1,y1-1); }
			else
				{setcolor(15);
				line(x1,y2,x2,y2);       	//inferior
				line(x1-1,y2+1,x2+1,y2+1);
			    //				  
				line(x2,y2,x2,y1);     		// derecha                                    
				line(x2+1,y2+1,x2+1,y1-1);                                           
				//	  
				setcolor(0); 
				line(x1,y1,x2,y1);  		//superior                             
				line(x1-1,y1-1,x2+1,y1-1);                                
				//					  
				line(x1,y2,x1,y1); 		//izquierda                                       
				line(x1-1,y2+1,x1-1,y1-1);}
			//				      
		}  //                                                                  
