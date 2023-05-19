public class Projects {
  private int pID;
  private int ProgramCores;
  private int ProgramRAM;
  private int ProgramSSD;
  private int ProgramGPU;
  private int ProgramBandwidth;
  private int ProgramExecutionTime;

  public Projects(int pID, int programCores, int programRAM, int programSSD, int programGPU, int programBandwidth) {
    this.pID = pID;
    this.ProgramCores = programCores;
    this.ProgramRAM = programRAM;
    this.ProgramSSD = programSSD;
    this.ProgramGPU = programGPU;
    this.ProgramBandwidth = programBandwidth;
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

  public int getProgramExecutionTime() {
    return ProgramExecutionTime;
  }

  public void setProgramExecutionTime(int programExecutionTime) {
    ProgramExecutionTime = programExecutionTime;
  }

}
