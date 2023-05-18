public class VMNetworked extends PlainVM {
  int Bandwidth;

  public VMNetworked(int VmId, int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth) {
    super(VmId, VMCPU, VMRAM, VMSoftware, PlainSSD);

    this.Bandwidth = Bandwidth;

  }
}
