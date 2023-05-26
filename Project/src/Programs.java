
public class Programs {
  private int pID;
  private int ProgramCores = 0;
  private int ProgramRAM = 0;
  private int ProgramSSD = 0;
  private int ProgramGPU = 0;
  private int ProgramBandwidth = 0;
  private int ProgramExpectedTime;
  private double priorityOrder;
  private long ProgramStartTime;

  private int RejectedTimes = 0;

  public Programs(int pID, int programCores, int programRAM, int programSSD, int programGPU, int programBandwidth,
      int programExpectedTime) {
    this.pID = pID;
    this.ProgramCores = programCores;
    this.ProgramRAM = programRAM;
    this.ProgramSSD = programSSD;
    this.ProgramGPU = programGPU;
    this.ProgramBandwidth = programBandwidth;
    this.ProgramExpectedTime = programExpectedTime;
    this.priorityOrder = calculatePriorityOrder();
    this.ProjectStartTime = getProjectStartTime();

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

  public long getProgramStartTime() {
    long start = System.currentTimeMillis();
    return start;

  }

  public float getExecutionTime() {
    float ExecutionTime = (System.currentTimeMillis() - ProgramStartTime)/ 1000F;

    return ExecutionTime;
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

  public void setProgramStartTime(long programStartTime) {
    ProgramStartTime = programStartTime;
  }

  public int getRejectedTimes() {
    return RejectedTimes;
  }

  public void setRejectedTimes(int rejectedTimes) {
    RejectedTimes = rejectedTimes;
  }

}
