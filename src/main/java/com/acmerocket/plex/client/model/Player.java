package com.acmerocket.plex.client.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import com.acmerocket.plex.client.Configuration;
import com.acmerocket.plex.client.PlexClient;

@Root(name="Player")
public class Player {

	// http://<CLIENT IP>:<CLIENT PORT>
	// /player/playback/playMedia?
	// key=%2Flibrary%2Fmetadata%2F<MEDIA ID>& 
	// offset=0&
	// X-Plex-Client-Identifier=<CLIENT ID>&
	// machineIdentifier=<SERVER ID>&
	// address=<SERVER IP>&
	// port=<SERVER PORT>&
	// protocol=http&
	// path=http%3A%2F%2F<SERVER IP>%3A<SERVER PORT>%2Flibrary%2Fmetadata%2F<MEDIA ID>

	// params: addr, port, media id, clientId, serverId, serverPort, serverAddress

	/* <Player 
	 * address="::ffff:192.168.1.29" 
	 * device="RaspberryPi" 
	 * machineIdentifier="fda839cf-c8f7-4bd9-98bc-0b4f037c163d" 
	 * model="RaspberryPi" 
	 * platform="Plex Home Theater" 
	 * platformVersion="" 
	 * product="Plex Home Theater" 
	 * profile="Raspberry PI" 
	 * state="playing" 
	 * title="RasPlex" 
	 * vendor="" 
	 * version="1.6.2.123-e23a7eef" />
	 */

	@Attribute(name="address")
    private String address;
	
	@Attribute(name="device")
    private String device;
	
	@Attribute(name="model")
    private String model;
	
	@Attribute(name="platform")
    private String platform;
	
	@Attribute(name="platformVersion")
    private String platformVersion; 
	
	@Attribute(name="product")
    private String product;
	
	@Attribute(name="profile")
    private String profile;
	
	@Attribute(name="state")
    private String state;
	
	@Attribute(name="title")
    private String title;
	
	@Attribute(name="vendor")
    private String vendor;
	
	@Attribute(name="version")
    private String version;

	@Attribute(name="machineIdentifier")
	private String machineId;

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	
	@Override
	public String toString() {
		return "Player [" + (address != null && address.length() > 0 ? "address=" + address + ", " : "")
				+ (device != null && device.length() > 0 ? "device=" + device + ", " : "") 
				+ (model != null ? "model=" + model + ", " : "")
				+ (platform != null && platform.length() > 0 ? "platform=" + platform + ", " : "")
				+ (platformVersion != null && platformVersion.length() > 0 ? "platformVersion=" + platformVersion + ", " : "")
				+ (product != null && product.length() > 0 ? "product=" + product + ", " : "")
				+ (profile != null && profile.length() > 0 ? "profile=" + profile + ", " : "") 
				+ (state != null && state.length() > 0 ? "state=" + state + ", " : "")
				+ (title != null && title.length() > 0 ? "title=" + title + ", " : "") 
				+ (vendor != null && vendor.length() > 0  ? "vendor=" + vendor + ", " : "")
				+ (version != null && version.length() > 0 ? "version=" + version + ", " : "")
				+ (machineId != null && machineId.length() > 0 ? "machineId=" + machineId : "") + "]";
	}
}
