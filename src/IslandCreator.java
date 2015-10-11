import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IslandCreator {
	static JFrame IslandBoard;
	static Container pane;
	static JLabel tile[][];
	static int type[][];
	static int height[][];
	static Random rand =new Random();
	static boolean stop =false;
	
	static final int C=59;
	static final int R=59;
	
	static JLabel character;
	static JLabel past;
	
	static final int OCEAN=1;
	static final int PLAIN=2;
	static final int MOUNTAIN=3;
	static final int VOLCANO=4;
	static final int RIVER=5;
	static final int LAKE=6;
	static final int FOREST=7;
	static final int BEACH=8;
	
	static final int WOCEAN=9;
	static final int WPLAIN=10;
	static final int WMOUNTAIN=11;
	static final int WVOLCANO=12;
	static final int WRIVER=13;
	static final int WLAKE=14;
	static final int WFOREST=15;
	static final int WBEACH=16;
	
	static final int FOCEAN=17;
	static final int FPLAIN=18;
	static final int FMOUNTAIN=19;
	static final int FVOLCANO=20;
	static final int FRIVER=21;
	static final int FLAKE=22;
	static final int FFOREST=23;
	static final int FBEACH=24;
	
	public static void main(String[] args) {
		//Set up the frame
		IslandBoard = new JFrame("Pi Island");
		IslandBoard.setSize(12*R, 12*R+22);
		IslandBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		IslandBoard.setLocationRelativeTo(null);
		pane = IslandBoard.getContentPane();
		pane.setLayout(new GridLayout(R,C,0,0));
		tile= new JLabel[R][C];
		type= new int[R][C];
		height= new int[R][C];		
		
		
		int season;
		
		IslandBoard.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                	System.out.println("Pressed");
                	if(!stop){
                		stop=true;
                	}else{
                		stop=false;
                	}
                }
            }

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		System.out.println("here2");
		
		while(!stop){
			System.out.println("here");
			season=rand.nextInt(100)+1;
			//season = 67;
			//Ocean base
			oceanBase();
		
			//Plains and height
			plainLayout();
		
			//Check for beach
			beaches();
		
			//Place a range
			mountainRange();
		
			//some rivers
			rivers();
		
			//plant forests
			forests();
		
			printIsland(season);
			
			IslandBoard.setVisible(true);
			
			try {
				Thread.sleep(5000);
				/*IslandBoard.getRootPane().addKeyListener(new KeyListener(){
					public void keyPressed(KeyEvent e)
		            {
		                if(e.getKeyCode() == KeyEvent.VK_ENTER)
		                {
		                    System.out.println("Pressed");
		                }
		            }

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});*/
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pane.removeAll();
			while(stop){
				//System.out.println("here4");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//stop=true;
			}
		}//While
		
		System.out.println("here3");
	}
	
	public static void printIsland(int timeCheck){
		if(timeCheck>80 && timeCheck<=100){
			for(int r=0; r<R; r++){
				for(int c=0; c<C; c++){
					type[r][c]+=8;
				}
			}
		}else if(timeCheck>50 && timeCheck<=75){
			for(int r=0; r<R; r++){
				for(int c=0; c<C; c++){
					type[r][c]+=16;
				}
			}
		}
		for(int r=0; r<R; r++){
			for(int c=0; c<C; c++){
				if(type[r][c] == OCEAN){
					tile[r][c] = new JLabel(pic("ocean"));
				}else if(type[r][c] == PLAIN){
					tile[r][c] = new JLabel(pic("plain"));
				}else if(type[r][c] == MOUNTAIN){
					tile[r][c] = new JLabel(pic("mountain"));
				}else if(type[r][c] == VOLCANO){
					tile[r][c] = new JLabel(pic("volcano"));
				}else if(type[r][c] == RIVER){
					tile[r][c] = new JLabel(pic("river"));
				}else if(type[r][c] == LAKE){
					tile[r][c] = new JLabel(pic("lake"));
				}else if(type[r][c] == FOREST){
					tile[r][c] = new JLabel(pic("forest"));
				}else if(type[r][c] == BEACH){
					tile[r][c] = new JLabel(pic("beach"));
				}
				
				else if(type[r][c] == WOCEAN){
					tile[r][c] = new JLabel(pic("wocean"));
				}else if(type[r][c] == WPLAIN){
					tile[r][c] = new JLabel(pic("wplain"));
				}else if(type[r][c] == WMOUNTAIN){
					tile[r][c] = new JLabel(pic("wmountain"));
				}else if(type[r][c] == WVOLCANO){
					tile[r][c] = new JLabel(pic("wvolcano"));
				}else if(type[r][c] == WRIVER){
					tile[r][c] = new JLabel(pic("wriver"));
				}else if(type[r][c] == WLAKE){
					tile[r][c] = new JLabel(pic("wlake"));
				}else if(type[r][c] == WFOREST){
					tile[r][c] = new JLabel(pic("wforest"));
				}else if(type[r][c] == WBEACH){
					tile[r][c] = new JLabel(pic("wbeach"));
				}
				
				else if(type[r][c] == FOCEAN){
					tile[r][c] = new JLabel(pic("focean"));
				}else if(type[r][c] == FPLAIN){
					tile[r][c] = new JLabel(pic("fplain"));
				}else if(type[r][c] == FMOUNTAIN){
					tile[r][c] = new JLabel(pic("fmountain"));
				}else if(type[r][c] == FVOLCANO){
					tile[r][c] = new JLabel(pic("fvolcano"));
				}else if(type[r][c] == FRIVER){
					tile[r][c] = new JLabel(pic("friver"));
				}else if(type[r][c] == FLAKE){
					tile[r][c] = new JLabel(pic("flake"));
				}else if(type[r][c] == FFOREST){
					tile[r][c] = new JLabel(pic("fforest"));
				}else if(type[r][c] == FBEACH){
					tile[r][c] = new JLabel(pic("fbeach"));
				}				
				pane.add(tile[r][c]);
			}
		}
	}
	
	public static void oceanBase(){
		for(int r=0; r<R; r++){
			for(int c=0; c<C; c++){
				height[r][c]=0;
				type[r][c]= OCEAN;
			}
		}
	}
	
	public static void plainLayout(){
		int ran;
		//randomNum= rand.nextInt((max - min) + 1) + min;
		int cr =C/2;
		int rr =R/2;
		
		for(int r=0; r<R; r++){
			
			for(int c=0; c<C; c++){	
				ran = rand.nextInt((5 - 1) + 1) + 1;
				//The># decides the island size. Bigger number = smaller island
				if(abs(abs(c-cr)-cr)+abs(abs(r-rr)-rr)+ran>40){
					height[r][c]=(abs(abs(c-cr)-cr)+abs(abs(r-rr)-rr))*5+rand.nextInt(((6-1)+1)+1);
					type[r][c]= PLAIN;
				}
			}
		}
	}
	
	public static void beaches(){
		int ran;
		for(int r=4; r<R-4; r++){
			ran = rand.nextInt((3 - 1) + 1) + 1;
			for(int c=4; c<C-4; c++){
				if(type[r][c]==PLAIN && (type[r+ran][c]==OCEAN || type[r-ran][c]==OCEAN)){
					type[r][c]= BEACH;
				}
				
			}
		}
	}

	public static void mountainRange(){
		//First pick a start
		int startDev = R/10;
		int start =0;
		int startc =0;
		int next;
		
		start = rand.nextInt((startDev*3-startDev*2)+1) + startDev*2;
		boolean valid=false;
		
		while(!valid){
			for(int c=0; c<C; c++){
				if (type[start][c]==PLAIN){
					valid=true;
				}
			}
			if(!valid){
				start++;
			}
			if(start>startDev*4){
				start = rand.nextInt((startDev*3-startDev*2)+1) + startDev*2;
			}
		}
		
		//Now pick the start column
		/*
		valid=false;
		while(!valid){
			for(int c=0; c<C; c++){
				if (type[start][c]==PLAIN && rand.nextInt(((10-1)+1)+1)>7){
					startc=c;
					valid=true;
				}
			}
		}
		*/
		
		startc=C/2 + 3-rand.nextInt(((6-1)+1)+1);
		
		//Now build the range
		int finish = rand.nextInt(((3-1)+1)+1);
		do{
			next = rand.nextInt(((100-1)+1)+1);
			height[start][startc]=2000;
			type[start][startc]=MOUNTAIN;/*
			height[start-1][startc]=((C/2)+(R/2))*5+rand.nextInt(((6-1)+1)+1);
			height[start+1][startc]=((C/2)+(R/2))*5+rand.nextInt(((6-1)+1)+1);
			height[start][startc-1]=((C/2)+(R/2))*5+rand.nextInt(((6-1)+1)+1);
			height[start][startc+1]=((C/2)+(R/2))*5+rand.nextInt(((6-1)+1)+1);*/
			
			if(rand.nextInt(((100-1)+1)+1)>85){
				height[start][startc] = 2010;
				type[start][startc] = VOLCANO;
				height[start-1][startc]=2000;
				type[start-1][startc]=MOUNTAIN;
				height[start+1][startc]=2000;
				type[start+1][startc]=MOUNTAIN;
				height[start][startc-1]=2000;
				type[start][startc-1]=MOUNTAIN;
				height[start][startc+1]=2000;
				type[start][startc+1]=MOUNTAIN;
			}
			
			if(next >= 1 && next <=5){
				startc--;
			}else if(next >= 6 && next <=10){
				startc++;
			}else if(next >= 11 && next <=37){
				startc--;
				start++;
			}else if(next >= 37 && next <=61){
				start++;
			}else if(next >= 62 && next <=85){
				start++;
				startc++;
			}else if(next >= 85 && next <=90){
				start+=2;
				startc--;
			}else if(next >= 91 && next <=95){
				start+=2;
			}else if(next >= 96 && next <=100){
				start+=2;
				startc++;
			}
			
			if(start+finish>startDev*9){
				valid=false;
			}
		}while(valid);
	}
	
	public static void rivers(){
		int dev = R/10;
		int start;
		int startc=0;
		int lowest;
		int nextc;
		int nextr;
		boolean found=false;
		boolean progress=true;
		int limit = rand.nextInt((3))+5;

		for(int river=1; river<=limit; river++){
			progress=true;
			start = rand.nextInt(((dev*8-dev*1)+1)+1);
			//find the mountain
			for(int c=0; !found && c<C; c++){
				found =false;
				if(type[start][c]==MOUNTAIN){
					found = true;
					if(rand.nextInt(((2-1)+1)+1)==1){
						startc=c-1;
					}else{
						int check=1;
						while(type[start][c+check]==MOUNTAIN){
							check++;
						}
						startc=c+check;
					}
				}
			}//the starting values have been found
			
			if(found){//make the river
				lowest=height[start][startc];
				nextr=start; nextc=startc;
				
				while(progress){
					type[start][startc]=RIVER;
					
					if(height[start-1][startc-1]<lowest){
						lowest=height[start-1][startc-1];
						nextr=start-1; nextc=startc-1;
					}else if(height[start-1][startc]<lowest){
						lowest=height[start-1][startc];
						nextr=start-1; nextc=startc;
					}else if(height[start-1][startc+1]<lowest){
						lowest=height[start-1][startc+1];
						nextr=start-1; nextc=startc+1;
					}else if(height[start][startc-1]<lowest){
						lowest=height[start][startc-1];
						nextr=start; nextc=startc-1;
					}else if(height[start][startc+1]<lowest){
						lowest=height[start][startc+1];
						nextr=start; nextc=startc+1;
					}else if(height[start+1][startc-1]<lowest){
						lowest=height[start+1][startc-1];
						nextr=start+1; nextc=startc-1;
					}else if(height[start+1][startc]<lowest){
						lowest=height[start+1][startc];
						nextr=start+1; nextc=startc;
					}else if(height[start+1][startc+1]<lowest){
						lowest=height[start+1][startc+1];
						nextr=start+1; nextc=startc+1;
					}
					
					if(nextr==start && nextc==startc){
						type[start][startc]=LAKE;
						progress=false;
					}else if(height[nextr][nextc]==0){
						type[nextr][nextc]=RIVER;
						progress=false;
					}else{
						start=nextr;
						startc=nextc;
					}
				}
				
			}else if(river>0){
				river--;
			}
			found=false;
		}
	}
	
	public static void forests(){
		int dev = R/10;
		int centerC;
		int centerR;
		int totalDecider = rand.nextInt(4);
		
		for(int f=totalDecider; f<=16; f++){
			centerC = rand.nextInt(dev*6)+dev*3;
			centerR = rand.nextInt(dev*6)+dev*3;
			
			for(int r=-2; r<=2; r++){
				for(int c=-2; c<=2; c++){
					if(type[centerR+r][centerC+c]==PLAIN && rand.nextInt(100)+1 + -10*(abs(r)+abs(c))>20){
						type[centerR+r][centerC+c]=FOREST;
					}
				}
			}	
		}
	}
	
	private static int abs(int i) {
		if(i<0){
			i=i*(-1);
		}
		return i;
	}

	public static ImageIcon pic(String place){
		ImageIcon icon = null;
		if(place.equals("ocean")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\Ocean.png");
		}else if (place.equals("plain")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\Plain.png");
		}else if (place.equals("mountain")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\Mountain.png");
		}else if (place.equals("volcano")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\Volcano.png");
		}else if (place.equals("river")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\River.png");
		}else if (place.equals("lake")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\Lake.png");
		}else if (place.equals("forest")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\Forest.png");
		}else if (place.equals("beach")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\Beach.png");
		}
		else if(place.equals("wocean")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\WOcean.png");
		}else if (place.equals("wplain")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\WPlain.png");
		}else if (place.equals("wmountain")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\WMountain.png");
		}else if (place.equals("wvolcano")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\WVolcano.png");
		}else if (place.equals("wriver")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\WRiver.png");
		}else if (place.equals("wlake")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\WLake.png");
		}else if (place.equals("wforest")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\WForest.png");
		}else if (place.equals("wbeach")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\WBeach.png");
		}
		else if(place.equals("focean")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\FOcean.png");
		}else if (place.equals("fplain")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\FPlain.png");
		}else if (place.equals("fmountain")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\FMountain.png");
		}else if (place.equals("fvolcano")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\FVolcano.png");
		}else if (place.equals("friver")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\FRiver.png");
		}else if (place.equals("flake")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\FLake.png");
		}else if (place.equals("fforest")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\FForest.png");
		}else if (place.equals("fbeach")){
			icon = new ImageIcon("C:\\Users\\Chain Chomp\\Desktop\\HackDay\\FBeach.png");
		}
		return icon;
	}

}
