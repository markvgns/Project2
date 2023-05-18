public class VMNetworkedGPU extends VMNetworked {
  int NetGPU;

  public VMNetworkedGPU(int VmId, int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth, int NetGPU) {
    super(VmId, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth);

    this.NetGPU = NetGPU;

  }
}
