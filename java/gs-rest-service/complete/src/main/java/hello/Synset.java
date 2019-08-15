package hello;

public class Synset {
    private final String sysnetId;
    private final String pos; /* part of speech */
    private final String source;

    public Synset(String sysnetId, String pos, String source) {
        this.sysnetId = sysnetId;
        this.pos = pos;
        this.source = source;
    }

    public String getSysnetId() {
        return sysnetId;
    }

    public String getPos() {
        return pos;
    }

    public String getSource() {
        return source;
    }
}
