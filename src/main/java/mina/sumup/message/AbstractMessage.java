package mina.sumup.message;

  import java.io.Serializable;

  /**
   * A base message for SumUp protocol messages.
   *
   * @author <a href="http://mina.apache.org">Apache MINA Project</a>
   */
  public abstract class AbstractMessage implements Serializable {
      private int sequence;

      public int getSequence() {
          return sequence;
      }

      public void setSequence(int sequence) {
          this.sequence = sequence;
      }
  }