package com.acmerocket.plex.client.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import com.acmerocket.plex.client.Configuration;
import com.acmerocket.plex.client.PlexClient;

@Root(name="Server")
public class Client {
    
    @Attribute(required=true)
    private String name;
    
    @Attribute(required=false)
    private String host;
    
    @Attribute(required=true)
    private String address;
    
    @Attribute(required=true)
    private int port;
    
    @Attribute(name="machineIdentifier",required=true)
    private String machineId;
    
    @Attribute(required=true)
    private String version;
    
    @Attribute(required=true)
    private String protocol;
    
    @Attribute(required=true)
    private String product;
    
    @Attribute(required=true)
    private String deviceClass;
    
    @Attribute(required=true)
    private String protocolVersion;
    
    @Attribute(required=false)
    private String protocolCapabilities;

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return this.host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return this.port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the machineId
     */
    public String getMachineId() {
        return this.machineId;
    }

    /**
     * @param machineId the machineId to set
     */
    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the protocol
     */
    public String getProtocol() {
        return this.protocol;
    }

    /**
     * @param protocol the protocol to set
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return this.product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @return the deviceClass
     */
    public String getDeviceClass() {
        return this.deviceClass;
    }

    /**
     * @param deviceClass the deviceClass to set
     */
    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    /**
     * @return the protocolVersion
     */
    public String getProtocolVersion() {
        return this.protocolVersion;
    }

    /**
     * @param protocolVersion the protocolVersion to set
     */
    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    /**
     * @return the protocolCapabilities
     */
    public String getProtocolCapabilities() {
        return this.protocolCapabilities;
    }

    /**
     * @param protocolCapabilities the protocolCapabilities to set
     */
    public void setProtocolCapabilities(String protocolCapabilities) {
        this.protocolCapabilities = protocolCapabilities;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Client [" + (this.name != null ? "name=" + this.name + ", " : "") + (this.host != null ? "host=" + this.host + ", " : "")
                + (this.address != null ? "address=" + this.address + ", " : "") + "port=" + this.port + ", "
                + (this.machineId != null ? "machineId=" + this.machineId + ", " : "") + (this.version != null ? "version=" + this.version + ", " : "")
                + (this.protocol != null ? "protocol=" + this.protocol + ", " : "") + (this.product != null ? "product=" + this.product + ", " : "")
                + (this.deviceClass != null ? "deviceClass=" + this.deviceClass + ", " : "")
                + (this.protocolVersion != null ? "protocolVersion=" + this.protocolVersion + ", " : "")
                + (this.protocolCapabilities != null ? "protocolCapabilities=" + this.protocolCapabilities : "") + "]";
    }
    
    public PlexClient plexClient() {
    	return new PlexClient(new Configuration(this.host, this.port, this.machineId));
    }
    
    //<Server 
    //name="RasPlex" 
    //host="192.168.1.29" 
    //address="192.168.1.29" 
    //port="3005" 
    //machineIdentifier="fda839cf-c8f7-4bd9-98bc-0b4f037c163d" 
    //version="1.6.2.123-e23a7eef" 
    //protocol="plex" 
    //product="plexhometheater" 
    //deviceClass="pc" //
    //protocolVersion="1" 
    //protocolCapabilities="navigation,playback,timeline,mirror,playqueues" />

}
