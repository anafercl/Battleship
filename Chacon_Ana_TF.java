import java.io.*;
import java.util.*;
public class Chacon_Ana_TF{
public static Scanner sc = new Scanner(System.in);
public static Scanner leerDatos = new Scanner(System.in);
public static Scanner car = new Scanner(System.in);
public static  BufferedReader in = new BufferedReader(new   InputStreamReader(System.in));
public static void main(String[] args) throws IOException{
int op=0, co=0, x=0, rpc=0, cpc=0;
String tabl_cpu[][]={{"x","1","2","3","4","5"},{"1","~","~","~","~","~"},{"2","~","~","~","~","~"},{"3","~","~","~","~","~"},{"4","~","~","~","~","~"},{"5","~","~","~","~","~"}};
String tabl_jug[][]={{"x","1","2","3","4","5"},{"1","~","~","~","~","~"},{"2","~","~","~","~","~"},{"3","~","~","~","~","~"},{"4","~","~","~","~","~"},{"5","~","~","~","~","~"}};
String datos_cpu[][]={{"x","1","2","3","4","5"},{"1","~","~","[]","[]","~"},{"2","~","~","~","~","[]"},{"3","~","~","~","~","[]"},{"4","~","~","~","~","~"},{"5","~","~","~","~","~"}};
String tabl2[][]={{"x","1","2","3","4","5"},{"1","~","~","~","~","~"},{"2","~","~","~","~","~"},{"3","~","~","~","~","~"},{"4","~","~","~","~","~"},{"5","~","~","~","~","~"}};
System.out.println("GRUPO 2447");
System.out.println("Nombre 1: 34615, Laura Magaña");
System.out.println("Nombre 1: 34644, Ana Chacón");
do
	{
		System.out.println("\n\t\tBATTLESHIP");
		System.out.println("Descripción del proyecto...............1");
		System.out.println("Instrucciones del juego................2");
		System.out.println("Referencias............................3");
		System.out.println("Jugar..................................4");
		System.out.println("Solución...............................5");
		System.out.println("Salir..................................6");
		try
			{
				System.out.print("Seleccione una opcion: ");
				op = Integer.parseInt(in.readLine( ));
			}
		catch (NumberFormatException e)
			{
				System.out.println("Opción invalida. Favor de seleccionar una opción del menú con los números del 1 al 6.");
				op=0;
			}
		switch(op)
			{
				case 1:
						System.out.println("\nBattleship es un juego de estrategia en el cual se tienen dos tableros, cada uno representando una");
						System.out.println("zona diferente del mar: la propia y la contraria. En el tablero del jugador, este puede colocar sus");
						System.out.println("barcos y mantener un registro de los tiros del oponente. En el tablero contrario, el jugador podrá");
						System.out.println("mantener un registro de sus tiros acertados y fallados hacia la zona de su oponente. El objetivo del");
						System.out.println("juego es ser el primero en hundir todos los barcos del oponente.");
						break;
				case 2:
						System.out.println("Instrucciones \n");
						System.out.println("Instrucción 1.  Antes de comenzar el juego se  tienen que colocar las naves ");
						System.out.println("que tendrá el jugador en el tablero. Se mostrará el numero de espacios que");
						System.out.println("tomará cada  nave y solo se podran  situar una a  lado de la otra,  ya sea ");
						System.out.println("verticalmente u horizontalmente, no en diagonal. \n");
						System.out.println("Instrucción 2.  Después  de colocar  las naves en el tablero,  empezará  el ");
						System.out.println("juego preguntando la coordenada donde se cree que se encuentra la nave  del ");
						System.out.println("contrincante. El CPU hará lo mismo. \n");
						System.out.println("Instrucción 3. Se alternarán entre el jugador y el CPU. \n");
						System.out.println("Instrucción 4.  En caso de coincidir con  la posición en donde se situa  la ");
						System.out.println("nave, se marcará con una X y en caso de fallar con una O. \n ");
						System.out.println("Instrucción 5.  Se gana derribando  todas las naves  del contrincante y  se");
						System.out.println("pierde cuando le derriban todas las naves primero \n");
						break;
				case 3:
						System.out.println("No hubo referencias consultadas.");
						break;
				case 4:
						seleccc(tabl_jug,tabl2);
						System.out.println("Tablero CPU");
						mostrar_tablero(tabl_cpu);
						System.out.println("Tu tablero");
						mostrar_tablero(tabl_jug);
						while(x<4)
							{
								co++;
								lanzar(datos_cpu,tabl_cpu);
								System.out.println("Tablero CPU");
								mostrar_tablero(tabl_cpu);
								System.out.println("Tu tablero");
								mostrar_tablero(tabl_jug);
								x=win(tabl_cpu);
								if(x==4)
									{
										System.out.println("\n--------------------------------¡ F E L I C I D A D E S !   G A N A S T E --------------------------------\n");
									}
								if(x<4)
									{
										System.out.println("\nTURNO DEL CPU\n");
										if(co<10)
											{
												rpc=moverpc(co);
												cpc=movecpc(co);
											}
										else
											{
												if(co<15)
													{
														rpc=mover2pc(co);
														cpc=mover2pc(co);
													}
												else
													{
														rpc=moverfpc(tabl_jug);
														cpc=movecfpc(tabl_jug);
													}
											}
										buscar(tabl_jug,rpc,cpc);
										System.out.println("Tablero CPU");
										mostrar_tablero(tabl_cpu);
										System.out.println("Tu tablero");
										mostrar_tablero(tabl_jug);
										x=win(tabl_jug);
										if(x==4)
											{
												System.out.println("\n--------------------------------P E R D I S T E :(--------------------------------\n");
											}
									}
							}
						tabl_jug=reinicio(tabl_jug,tabl2);
						tabl_cpu=reinicio(tabl_cpu,tabl2);
						co=0;
						x=0;
						break;
				case 5:
						System.out.println("Tablero CPU");
						mostrar_tablero(datos_cpu);
						break;
				case 6:
						break;
				default:
						System.out.println("Opción no disponible");
						break;
			}
	}while(op!=6);
}
public static void seleccc(String m[][], String og[][])throws IOException
{
	int a=0,b=0,r=0,c=0,rr=0,cc=0;
	String x;
	x= new String("[]");
	System.out.println("1. Selecciona donde poner tu nave");
	for(rr=0; rr<6; rr++)
		{
			for(cc=0; cc<6; cc++)
				{
					System.out.print(m[rr][cc]+"\t");
				}
			System.out.print("\n");
			System.out.print("\n");
		}
	for(b=1;b<3;b++)
	{
	System.out.println("Nave "+b+" (2 piezas)");
	for(a=1;a<3;a++)
	{
	System.out.println("Pieza  "+a+":");
	try
		{
			System.out.print("Renglon: ");
			r=Integer.parseInt(in.readLine( ));
			System.out.print("Columna: ");
			c=Integer.parseInt(in.readLine( ));
			m[r][c]=x;
		}
	catch (Exception e)
		{
			System.out.println("Opción invalida. Favor de ingresar coordenadas con números del 1 al 5.");
			m=reinicio(m,og);
			seleccc(m,og);
			a=4;
			b=4;
		}


	}
	}

}
public static void mostrar_tablero (String m[][])
	{
		int r=0,c=0;
		for(r=0;r<6;r++)
				{
					for(c=0;c<6;c++)
						{

							System.out.print(m[r][c]);
							System.out.print("\t");


						}
						System.out.print("\n");
						System.out.print("\n");
		}
	}

public static int win(String m[][])
	{
		int r=0, c=0, x=0;
		for(r=0; r<6; r++)
			{
				for(c=0; c<6; c++)
					{
						if(m[r][c].equals("X"))
							{
								x++;
							}
					}
			}
		return x;
	}
public static String[][] reinicio(String used[][], String og[][])
	{
		int r=0, c=0;
		for(r=0; r<6; r++)
			{
				for(c=0; c<6; c++)
					{
						used[r][c]=og[r][c];
					}
			}
		return used;
	}
//jugador
public static void lanzar(String m[][],String m2[][])throws IOException
{
	int r=0,c=0,rr=0,cc=0,p=0;
	String f,h,o;
	o=new String("[]");
	f=new String("O");
	h=new String("X");
	try
		{
			System.out.println("Seleccione coordenadas donde lanzar");
			System.out.print("Renglon: ");
			rr=Integer.parseInt(in.readLine( ));
			System.out.print("Columna: ");
			cc=Integer.parseInt(in.readLine( ));
	if(f.compareTo(m2[rr][cc])==0 )
	{
		System.out.println("opcion ya fue seleccionada previamente");
		lanzar(m,m2);
	}
	if( h.compareTo(m2[rr][cc])==0)
		{
			System.out.println("opcion ya fue seleccionada previamente");
			lanzar(m,m2);
	}
   if(o.compareTo(m[rr][cc])==0)
						{
							m2[rr][cc]=h;

						}
						else
						{
							m2[rr][cc]=f;
						}

}

catch(Exception e)
	{
		System.out.println("Opción invalida. Favor de ingresar coordenadas con números del 1 al 5.");
		lanzar(m,m2);
	}


}
//PC
public static String[][] buscar(String m[][], int rx, int cx)
	{
		int r=0, c=0;
		for(r=0; r<6; r++)
			{
				for(c=0; c<6; c++)
						{
							if(rx==r)
								{
									if(cx==c)
										{
											if(m[r][c].equals("[]"))
												{
													m[r][c]="X";
												}
											else
												{
													m[r][c]="O";
												}
										}
								}
						}
			}
		return m;
	}
public static int moverpc(int co)
	{
		int r=0, a=0;
		if(co>5)
			{
				a=co-5;
				if(a==1)
					{
						r=3;
					}
				if(a==2)
					{
						r=3;
					}
				if(a==3)
					{
						r=5;
					}
				if(a==4)
					{
						r=5;
					}
			}
		else
			{
				if(co==1)
					{
						r=2;
					}
				if(co==2)
					{
						r=4;
					}
				if(co==3)
					{
						r=4;
					}
				if(co==4)
					{
						r=1;
					}
				if(co==5)
					{
						r=1;
					}
			}
		return r;
	}
public static int movecpc(int co)
	{
		int c=0, a=0;
		if(co>5)
			{
				a=co-5;
				if(a==1)
					{
						c=5;
					}
				if(a==2)
					{
						c=2;
					}
				if(a==3)
					{
						c=2;
					}
				if(a==4)
					{
						c=4;
					}
			}
		else
			{
				if(co==1)
					{
						c=1;
					}
				if(co==2)
					{
						c=1;
					}
				if(co==3)
					{
						c=3;
					}
				if(co==4)
					{
						c=3;
					}
				if(co==5)
					{
						c=5;
					}
			}
		return c;
	}
public static int mover2pc(int co)
	{
		int r=0;
		if(co==10)
			{
				r=1;
			}
		if(co==11)
			{
				r=3;
			}
		if(co==12)
			{
				r=5;
			}
		if(co==13)
			{
				r=2;
			}
		if(co==14)
			{
				r=4;
			}
		return r;
	}
public static int movec2pc(int co)
	{
		int c=0;
		if(co==10)
			{
				c=1;
			}
		if(co==11)
			{
				c=3;
			}
		if(co==12)
			{
				c=5;
			}
		if(co==13)
			{
				c=2;
			}
		if(co==14)
			{
				c=4;
			}
		return c;
	}
public static int moverfpc(String m[][])
	{
		int r=0, c=0, rx=0;
		for(r=0; r<6; r++)
			{
				for(c=0; c<6; c++)
					{
						if(m[r][c].equals("~"))
							{
								rx=r;
							}
						else
							{
								if(m[r][c].equals("[]"))
									{
										rx=r;
									}
							}
					}
			}
		return rx;
	}
public static int movecfpc(String m[][])
	{
		int c=0, r=0, cx=0;
		for(r=0; r<6; r++)
			{
				for(c=0; c<6; c++)
					{
						if(m[r][c].equals("~"))
							{
								cx=c;
							}
						else
							{
								if(m[r][c].equals("[]"))
									{
										cx=c;
									}
							}
					}
			}
		return cx;
	}
}