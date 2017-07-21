package www.wanfin.com.support.tcc;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import www.wanfin.com.support.fasterxml.OffsetDateTimeToIso8601Deserializer;
import www.wanfin.com.support.fasterxml.OffsetDateTimeToIso8601Serializer;

import lombok.Data;

/**
 * 
 * @author Administrator
 *
 */
@Data
public class Participant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String uri;
	@JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
	@JsonDeserialize(using = OffsetDateTimeToIso8601Deserializer.class)
	private OffsetDateTime expires;

	public Participant(String uri, OffsetDateTime expires) {
		super();
		this.uri = uri;
		this.expires = expires;
	}

	public Participant() {
		super();
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public OffsetDateTime getExpires() {
		return expires;
	}

	public void setExpires(OffsetDateTime expires) {
		this.expires = expires;
	}

	 

}
