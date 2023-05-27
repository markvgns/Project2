public class VMNetworkedGPU extends VMNetworked {
  private int NetGPU;

  private int Allocated_NetGPU=0;

  public VMNetworkedGPU(int VmId, int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth, int NetGPU) {
    super(VmId, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth);

    this.NetGPU = NetGPU;

  }

  public int getNetGPU() {
    return NetGPU;
  }

  public void setNetGPU(int netGPU) {
    NetGPU = netGPU;
  }

  public int getAllocated_NetGPU() {
    return Allocated_NetGPU;
  }

  public void setAllocated_NetGPU(int allocated_NetGPU) {
    Allocated_NetGPU = allocated_NetGPU;
  }
}
