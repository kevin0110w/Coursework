public class OneDimMover {
  private int pos = 0;

  public void setPos(int pos) {
    this.pos = pos;
  }

  public int getPos() {
    return pos;
  }
  //
  // public synchronized void modify(int change) {
  //   int currentPos = m.getPos();
  //   currentPos += change;
  //   m.setPos(currentPos);
  // }

  public static class Changer implements Runnable {
    private int change,nChanges;
    private OneDimMover m;

    public Changer(int change,int nChanges,OneDimMover m) {
        this.change = change;
        this.nChanges = nChanges;
        this.m = m;
      }

      public void run() {
        for(int i=0;i<nChanges;i++) {
          synchronized(m) { // necessary to 'lock' the shared object
          int currentPos = m.getPos();
          currentPos += change;
          m.setPos(currentPos);
        }}
    }
  }

  public static void main(String[] args) {
    OneDimMover odm = new OneDimMover();
    Thread[] t = new Thread[100];
    for(int i=0;i<50;i++) {
        t[i] = new Thread(new Changer(1,200,odm));
        t[i+50] = new Thread(new Changer(-2,100,odm));
      }

    for(int i=0;i<100;i++) {
      t[i].start();
    }
    try {
      for(int i=0;i<100;i++){
        t[i].join();
      } // A
    }catch(Exception e) {
    }
    System.out.println(odm.getPos());
  }
}
