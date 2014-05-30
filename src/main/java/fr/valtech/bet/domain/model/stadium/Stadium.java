package fr.valtech.bet.domain.model.stadium;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Created by lyazid.selmi on 30/05/2014.
 */
@Entity
@Table(name = "STADIUM")
public class Stadium {

    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "ID")
    private byte id;

    @Column(name = "NAME")
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stadium stadium = (Stadium) o;

        if(this.getName().toLowerCase().equals(stadium.getName().toLowerCase()))
            return true;
        else
            return false;
    }
}
