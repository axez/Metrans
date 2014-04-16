package com.theradikalsoftware.metrans;



import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class MainActivity extends Activity implements  OnTouchListener{

	public int x,y,x2,y2,OP=1;
	public boolean move=false,move2=false, move3=false;
	private TextView texte; 
	private ImageView tex;
	private String text;
    private RelativeLayout l;
StringBuilder builder= new StringBuilder();
	/*private NotificationManager nm; //Variables al admin de notif.
	private static final int ID_NOTIFICACION_CREAR = 1;*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		
		super.onCreate(savedInstanceState);
	//	tex=new ImageView(this);
		setContentView(R.layout.activity_main);

		RelativeLayout  l = (RelativeLayout)findViewById(R.id.op);
		l.setOnTouchListener(this);
		setContentView(l);
		//nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //Declaracion de notificacion
		//noti();
		 
	}

	
	@Override
	//Creacion de menu
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	/*****Selector de funciones desde el menu*****/
	@Override 
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
			case R.id.exit:
			Exit();
			break;
		}
		return true;
	}
	
	/*****Funciones del menu de esta actividad*****/
	private void Exit() {
		
		//nm.cancel(ID_NOTIFICACION_CREAR);
		finish();
	    android.os.Process.killProcess(android.os.Process.myPid());
	    super.onDestroy();
	}

	@Override
public boolean onTouch(View v, MotionEvent me) {
		
		builder.setLength(0);
	
		switch (me.getAction()){
		case MotionEvent.ACTION_DOWN:
		builder.append("se Toco:");
		x=(int) me.getX();
		y= (int) me.getY();
		move2=true;
			break;
		case MotionEvent.ACTION_MOVE:
			
////			 Intent act = new Intent(this, MainActivity2.class);
////			    act.putExtra("OP", x);
////			    act.putExtra("OP2", y);
////			   
//			    startActivity(act);
			move3=true;
			break;
		case MotionEvent.ACTION_UP:
			builder.append("se dejo de Tocar:");
			x2=(int) me.getX();
			y2= (int) me.getY();
			move=true;
			break;
		}
		if(move==true && move2==true){
		if(x2>x){
			builder.append("slash drerecha");
			 Intent act = new Intent(this,SplashScreen.class);
			 startActivity(act);
		}
			if(x>x2){
				builder.append("slash izquierda");
//				Intent act2 = new Intent(this,MainActivity3.class);
//				 startActivity(act2);
			}
		
		move=false;
		move2=false;
		}
		 //text= builder.toString();
		//Log.d("Touchtext",text);
		//texte.setText(text);
		return true;
	}
	
	/*private void noti(){
		//Contenido de notificacion
		Notification notificacion = new Notification( 
                R.drawable.metrans_logo,
                "Metrans inicializando... Bienvenido",
                System.currentTimeMillis() );
		//Fin de contenido de la notificacion
		PendingIntent intencionPendiente = PendingIntent.getActivity(
		          this, 0, new Intent(this, MainActivity.class), 0);
		notificacion.setLatestEventInfo(this, "Por favor espera",
		       "información adicional", intencionPendiente);
	
		 nm.notify(ID_NOTIFICACION_CREAR, notificacion); //Enviamos la notificacion al status bar
		
	}*/
	

	
}
