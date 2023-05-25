public class VMNetworked extends PlainVM {
  private int Bandwidth;

  private int Allocated_Bandwidth;

  public VMNetworked(int VmId, int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth) {
    super(VmId, VMCPU, VMRAM, VMSoftware, PlainSSD);

    this.Bandwidth = Bandwidth;

  }

  public int getBandwidth() {
    return Bandwidth;
  }

  public void setBandwidth(int bandwidth) {
    Bandwidth = bandwidth;
  }

  public int getAllocated_Bandwidth() {
    return Allocated_Bandwidth;
  }

  public void setAllocated_Bandwidth(int allocated_Bandwidth) {
    Allocated_Bandwidth = allocated_Bandwidth;
  }
}
