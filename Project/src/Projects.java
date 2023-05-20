import java.util.Comparator;
import java.util.PriorityQueue;


public class Projects {
  private int pID;
  private int ProgramCores;
  private int ProgramRAM;
  private int ProgramSSD;
  private int ProgramGPU;
  private int ProgramExpectedTime;
  private long priorityOrder;
  
  PriorityQueue<Projects> ProjectsQueue = new PriorityQueue<>
    (  
        Comparator.comparing((Projects k) -> k.priorityOrder )   /* !!kathe fora pou exo kainourgio project kalo thn calculatePriorityOrder */
    
    );
  
  public Projects(int pID, int programCores, int programRAM, int programSSD, int programGPU, int programBandwidth, int programExpectedTime) {
    this.pID = pID;
    this.ProgramCores = programCores;
    this.ProgramRAM = programRAM;
    this.ProgramSSD = programSSD;
    this.ProgramGPU = programGPU;
    this.ProgramBandwidth = programBandwidth;
    this.ProgramExpectedTime = programExpectedTime; 
    this.priorityOrder = 0;
  }

  public int getpID() {
    return pID;
  }

  public void setpID(int pID) {
    this.pID = pID;
  }

  public int getProgramCores() {
    return ProgramCores;
  }

  public void setProgramCores(int programCores) {
    ProgramCores = programCores;
  }

  public int getProgramRAM() {
    return ProgramRAM;
  }

  public void setProgramRAM(int programRAM) {
    ProgramRAM = programRAM;
  }

  public int getProgramSSD() {
    return ProgramSSD;
  }

  public void setProgramSSD(int programSSD) {
    ProgramSSD = programSSD;
  }

  public int getProgramGPU() {
    return ProgramGPU;
  }

  public void setProgramGPU(int programGPU) {
    ProgramGPU = programGPU;
  }

  public int getProgramBandwidth() {
    return ProgramBandwidth;
  }

  public void setProgramBandwidth(int programBandwidth) {
    ProgramBandwidth = programBandwidth;
  }

 public int getProgramExpectedTime() {
      return ProgramExpectedTime;
    }
  
    public void setProgramExecutionTime(int programExpectedTime) {
      ProgramExpectedTime = programExpectedTime;
    }

    public int getExecutionTime()
    {
        int ExecutionTime = getCurrentExecTime() - getstartExecTime();  /* opou getCurrentExecTime - getstartExecTime einai h diafora apo thn  */
                                                                          /* geniki ora olou tou to CLI ekeini ti stigmh(auto metraei apo otan arxise o kodikas olos)  */
                                                                          /* meion thn stimh pou arxise na ekteleite to sigekrimeno program */
        return ExecutionTime;
    }

  
    public void calculatePriorityOrder()
    {
        long priorityOrder;
        int remainingCores = ComputerCluster.Max_CPU - ;      //CLI.getREMAIN_CPU();
        int remainingRAM = ComputerCluster.Max_RAM - ;        //CLI.getREMAIN_RAM();
        int remainingSSD = ComputerCluster.Max_SSD - ;        //CLI.getREMAIN_SSD();               DEN LEITOURGOUN OI GETTERS EPEIDH exoume balei tis remain metablhtes sto
        int remainingGPU = ComputerCluster.Max_GPU - ;        //CLI.getREMAIN_GPU();                  CLI ises me tis static final tou ComputerCluster kai tis blepei os static
        int remainingBandwidth = ComputerCluster.Max_Ethernet - ;       //CLI.getREMAIN_Ethernet();     to afhno etsi kai to ftiaxno avrio

        this.priorityOrder = (getProgramCores()/ remainingCores) + (getProgramRAM()/ remainingRAM) + 
        (getProgramSSD()/ remainingSSD) + (getProgramGPU()/remainingGPU) + (getProgramBandwidth()/remainingBandwidth);


    }

    



}
