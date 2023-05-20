
public class Projects {
  private int pID;
  private int ProgramCores;
  private int ProgramRAM;
  private int ProgramSSD;
  private int ProgramGPU;
  private int ProgramBandwidth;
  private int ProgramExpectedTime;
  private double priorityOrder;

  public Projects(int pID, int programCores, int programRAM, int programSSD, int programGPU, int programBandwidth,
      int programExpectedTime) {
    this.pID = pID;
    this.ProgramCores = programCores;
    this.ProgramRAM = programRAM;
    this.ProgramSSD = programSSD;
    this.ProgramGPU = programGPU;
    this.ProgramBandwidth = programBandwidth;
    this.ProgramExpectedTime = programExpectedTime;
    this.priorityOrder = calculatePriorityOrder();
  }

  public double calculatePriorityOrder() {
    double order = 0;
    int remainingCores = ComputerCluster.Max_CPU - CLI.getREMAIN_CPU();
    int remainingRAM = ComputerCluster.Max_RAM - CLI.getREMAIN_RAM();
    int remainingSSD = ComputerCluster.Max_SSD - CLI.getREMAIN_SSD();
    int remainingGPU = ComputerCluster.Max_GPU - CLI.getREMAIN_GPU();
    int remainingBandwidth = ComputerCluster.Max_Ethernet - CLI.getREMAIN_Ethernet();

    order = (getProgramCores() / remainingCores) + (getProgramRAM() / remainingRAM) +
        (getProgramSSD() / remainingSSD) + (getProgramGPU() / remainingGPU)
        + (getProgramBandwidth() / remainingBandwidth);

    return order;

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

  public void setProgramExpectedTime(int programExpectedTime) {
    ProgramExpectedTime = programExpectedTime;
  }

  public double getPriorityOrder() {
    return priorityOrder;
  }

  public void setPriorityOrder(double priorityOrder) {
    this.priorityOrder = priorityOrder;
  }

  // public int getExecutionTime() {
  // int ExecutionTime = getCurrentExecTime() - getstartExecTime(); /*
  // * opou getCurrentExecTime - getstartExecTime einai h
  // * diafora apo thn
  // */
  // /*
  // * geniki ora olou tou to CLI ekeini ti stigmh(auto metraei apo otan arxise o
  // * kodikas olos)
  // */
  // /* meion thn stimh pou arxise na ekteleite to sigekrimeno program */
  // return ExecutionTime;
  // }

}