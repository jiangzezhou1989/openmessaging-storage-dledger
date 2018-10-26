package org.apache.rocketmq.dleger;

import com.beust.jcommander.Parameter;
import java.io.File;
import org.apache.rocketmq.dleger.store.file.DLegerMmapFileStore;

public class DLegerConfig {

    public static final String MEMORY = "MEMORY";
    public static final String FILE = "FILE";


    @Parameter(names = {"--group", "-g"}, description = "Group of this server")
    private String group = "default";

    @Parameter(names = {"--id", "-i"}, description = "Self id of this server")
    private String selfId = "n0";

    @Parameter(names = {"--peers", "-p"}, description = "Peer info of this server")
    private String peers = "n0-localhost:20911";

    @Parameter(names = {"--store-base-dir", "-s"}, description = "The base store dir of this server")
    private String storeBaseDir = File.separator + "tmp" + File.separator + "dlegerstore";

    private String storeType = FILE; //FILE, MEMORY
    private String dataStorePath;
    private String indexStorePath;

    private int maxPendingRequestsNum = 10000;

    private int maxWaitAckTimeMs = 1500;

    private int maxPushTimeOutMs = 1000;

    private boolean enableLeaderElector = true;


    private int heartBeatTimeIntervalMs = 1000;

    private int minVoteIntervalMs = 300;
    private int maxVoteIntervalMs = 1000;



    private int mappedFileSizeForEntryData = 1024 * 1024 * 1024;
    private int mappedFileSizeForEntryIndex = DLegerMmapFileStore.INDEX_NUIT_SIZE * 1024 * 1024;

    private boolean enablePushToFollower = true;

    public String getDefaultPath() {
        return  storeBaseDir + File.separator + group + "-" + selfId;
    }

    public String getDataStorePath() {
        if (dataStorePath == null) {
            return storeBaseDir + File.separator + group + "-" + selfId + File.separator + "data";
        }
        return dataStorePath;
    }

    public void setDataStorePath(String dataStorePath) {
        this.dataStorePath = dataStorePath;
    }

    public String getIndexStorePath() {
        if (indexStorePath == null) {
            return storeBaseDir + File.separator + group + "-" + selfId + File.separator + "index";
        }
        return indexStorePath;
    }

    public void setIndexStorePath(String indexStorePath) {
        this.indexStorePath = indexStorePath;
    }

    public int getMappedFileSizeForEntryData() {
        return mappedFileSizeForEntryData;
    }

    public void setMappedFileSizeForEntryData(int mappedFileSizeForEntryData) {
        this.mappedFileSizeForEntryData = mappedFileSizeForEntryData;
    }

    public int getMappedFileSizeForEntryIndex() {
        return mappedFileSizeForEntryIndex;
    }

    public void setMappedFileSizeForEntryIndex(int mappedFileSizeForEntryIndex) {
        this.mappedFileSizeForEntryIndex = mappedFileSizeForEntryIndex;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSelfId() {
        return selfId;
    }

    public void setSelfId(String selfId) {
        this.selfId = selfId;
    }

    public String getPeers() {
        return peers;
    }

    public void setPeers(String peers) {
        this.peers = peers;
    }

    public String getStoreBaseDir() {
        return storeBaseDir;
    }

    public void setStoreBaseDir(String storeBaseDir) {
        this.storeBaseDir = storeBaseDir;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public boolean isEnableLeaderElector() {
        return enableLeaderElector;
    }

    public void setEnableLeaderElector(boolean enableLeaderElector) {
        this.enableLeaderElector = enableLeaderElector;
    }

    //for builder semantic
    public DLegerConfig group(String group) {
        this.group =  group;
        return this;
    }

    public DLegerConfig selfId(String selfId) {
        this.selfId = selfId;
        return this;
    }

    public DLegerConfig peers(String peers) {
        this.peers = peers;
        return this;
    }

    public DLegerConfig storeBaseDir(String dir) {
        this.storeBaseDir =  dir;
        return this;
    }

    public boolean isEnablePushToFollower() {
        return enablePushToFollower;
    }

    public void setEnablePushToFollower(boolean enablePushToFollower) {
        this.enablePushToFollower = enablePushToFollower;
    }

    public int getMaxPendingRequestsNum() {
        return maxPendingRequestsNum;
    }

    public void setMaxPendingRequestsNum(int maxPendingRequestsNum) {
        this.maxPendingRequestsNum = maxPendingRequestsNum;
    }

    public int getMaxWaitAckTimeMs() {
        return maxWaitAckTimeMs;
    }

    public void setMaxWaitAckTimeMs(int maxWaitAckTimeMs) {
        this.maxWaitAckTimeMs = maxWaitAckTimeMs;
    }

    public int getMaxPushTimeOutMs() {
        return maxPushTimeOutMs;
    }

    public void setMaxPushTimeOutMs(int maxPushTimeOutMs) {
        this.maxPushTimeOutMs = maxPushTimeOutMs;
    }

    public int getHeartBeatTimeIntervalMs() {
        return heartBeatTimeIntervalMs;
    }

    public void setHeartBeatTimeIntervalMs(int heartBeatTimeIntervalMs) {
        this.heartBeatTimeIntervalMs = heartBeatTimeIntervalMs;
    }

    public int getMinVoteIntervalMs() {
        return minVoteIntervalMs;
    }

    public void setMinVoteIntervalMs(int minVoteIntervalMs) {
        this.minVoteIntervalMs = minVoteIntervalMs;
    }

    public int getMaxVoteIntervalMs() {
        return maxVoteIntervalMs;
    }

    public void setMaxVoteIntervalMs(int maxVoteIntervalMs) {
        this.maxVoteIntervalMs = maxVoteIntervalMs;
    }
}
