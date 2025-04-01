package datamusic.rest.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import datamusic.rest.dto.v1_0.UserAccount;
import datamusic.rest.resource.v1_0.UserAccountResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collection;

/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/user-account.properties",
	scope = ServiceScope.PROTOTYPE, service = UserAccountResource.class
)
public class UserAccountResourceImpl extends BaseUserAccountResourceImpl {
	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<UserAccount>, UnsafeFunction<UserAccount, UserAccount, Exception>, Exception> unsafeBiConsumer) {

	}
}