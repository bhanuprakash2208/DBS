package com.dbs.hibernate.HIbernateDemo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class SubscriptionEntity implements Serializable
{
 
    private static final long serialVersionUID = -6790693372846798580L;
    @Id
    private Integer subscriptionId;
 
    private String subscriptionName;
     
    @ManyToMany(mappedBy = "subscriptions")
    private Set<ReaderEntity> readers;
 
    public Integer getSubscriptionId() {
        return subscriptionId;
    }
 
    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
 
    public String getSubscriptionName() {
        return subscriptionName;
    }
 
    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }
 
    public Set<ReaderEntity> getReaders() {
        return readers;
    }
 
    public void setReaders(Set<ReaderEntity> readers) {
        this.readers = readers;
    }

}
