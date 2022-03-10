package uz.pdp.appwarehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwarehouse.entity.Attachment;

@Projection(types = Attachment.class)
public interface AttachmentProjection {
    Integer getId();

    String getName();

    Long getSize();

    String getContentType();
}
