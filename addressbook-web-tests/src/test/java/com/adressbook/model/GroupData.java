package com.adressbook.model;

import org.hibernate.annotations.Type;
import org.hibernate.type.DateType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "group_list")
public class GroupData {
    @Id
    @Column(name="group_id")
    private int id;

    @Column(name="group_name")
    private String name;

    @Column(name="group_header")
    @Type(type = "text")
    private String header;

    @Column(name="group_footer")
    @Type(type = "text")
    private String footer;

    @Column(name="deprecated")
    private Timestamp deprecated;

    public Timestamp getDeprecated() {
        return deprecated;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                ", deprecated=" + deprecated +
                '}';
    }

    public GroupData withDeprecated(Timestamp deprecated) {
        this.deprecated = deprecated;
        return this;
    }

    public GroupData() {
    }

    public GroupData withId(int id) {
        this.id = id;;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(name, groupData.name) &&
                Objects.equals(header, groupData.header) &&
                Objects.equals(footer, groupData.footer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, header, footer);
    }
}
