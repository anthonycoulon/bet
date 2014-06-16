package fr.valtech.bet.domain.model.user;

import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AVATAR")
public class Avatar {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FILE", columnDefinition = "longblob")
    private byte[] file;

    @Column(name = "CONTENT_TYPE", length = 15)
    private String contentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Avatar avatar = (Avatar) o;

        if (id != null ? !id.equals(avatar.id) : avatar.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Avatar{");
        sb.append("id=").append(id);
        sb.append(", file=").append(Arrays.toString(file));
        sb.append(", contentType='").append(contentType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
