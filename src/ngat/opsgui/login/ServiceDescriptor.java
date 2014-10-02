/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ngat.opsgui.login;

import ngat.util.XmlConfigurable;
import org.jdom.Element;

/**
 *
 * @author eng
 */
public class ServiceDescriptor implements XmlConfigurable {
    
    private String name;
    private String description;
    private String gatewayHost;
    private String gatewayName;
    private String providerHost;
    private String providerName;
    private long lookbackTime;
    private long pollingInterval;
    private long broadcastInterval;

    public ServiceDescriptor(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGatewayHost() {
        return gatewayHost;
    }

    public void setGatewayHost(String gatewayHost) {
        this.gatewayHost = gatewayHost;
    }

    public String getProviderHost() {
        return providerHost;
    }

    public void setProviderHost(String providerHost) {
        this.providerHost = providerHost;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }
    
    

    public long getLookbackTime() {
        return lookbackTime;
    }

    public void setLookbackTime(long lookbackTime) {
        this.lookbackTime = lookbackTime;
    }

    public long getPollingInterval() {
        return pollingInterval;
    }

    public void setPollingInterval(long pollingInterval) {
        this.pollingInterval = pollingInterval;
    }

    public long getBroadcastInterval() {
        return broadcastInterval;
    }

    public void setBroadcastInterval(long broadcastInterval) {
        this.broadcastInterval = broadcastInterval;
    }

    public String getName() {
        return name;
    }

    @Override
    public void configure(Element node) throws Exception {

        description = node.getChildTextTrim("description");
        
        Element gwnode = node.getChild("gateway");

        gatewayHost = gwnode.getChildTextTrim("host");

        gatewayName = gwnode.getChildTextTrim("name");
        
         Element pnode = node.getChild("provider");

        providerHost = pnode.getChildTextTrim("host");

        providerName = pnode.getChildTextTrim("name");
       

        lookbackTime = Long.parseLong(node.getChildTextTrim("lookback"));

        pollingInterval = Long.parseLong(node.getChildTextTrim("polling"));

        broadcastInterval = Long.parseLong(node.getChildTextTrim("bcast"));


    }
    
     public Element createNode() {

         Element node = new Element("service");
         node.setAttribute("name", name);
         
         node.addContent(new Element("description").setText(description));
         
         Element gwnode = new Element("gateway");
         node.addContent(gwnode);
         Element gwnamenode = gwnode.addContent(new Element("name").setText(gatewayName));
         Element gwhostnode = gwnode.addContent(new Element("host").setText(gatewayHost));
         
         Element pnode = new Element("provider");
         node.addContent(pnode);
         Element pnamenode = pnode.addContent(new Element("name").setText(providerName));
         Element phostnode = pnode.addContent(new Element("host").setText(providerHost));
         
         node.addContent(new Element("lookback").setText(String.format("%8d",lookbackTime)));
         node.addContent(new Element("polling").setText(String.format("%8d",pollingInterval)));
         node.addContent(new Element("bcast").setText(String.format("%8d",broadcastInterval)));
         
         return node;
         
     }

    @Override
    public String toString() {
        return "ServiceDescriptor{" + "name=" + name + ", gatewayHost=" + gatewayHost + ", gatewayName=" + gatewayName + ", providerHost=" + providerHost + ", providerName=" + providerName + ", lookbackTime=" + lookbackTime + ", pollingInterval=" + pollingInterval + ", broadcastInterval=" + broadcastInterval + '}';
    }

}
