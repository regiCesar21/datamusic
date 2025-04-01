package datamusic.rest.internal.dto.v1_0.converter;

import datamusic.rest.dto.v1_0.UserAccount;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.dto.converter.DTOConverterContext;



import org.osgi.service.component.annotations.Component;

/**
 * @author Regisson Aguiar
 */
@Component(
        property = "dto.class.name=com.datamusic.app.model.UserAccount",
        service = DTOConverter.class
)
public class UserAccountResourceDTOConverter
        implements DTOConverter<com.datamusic.app.model.UserAccount, UserAccount> {

    @Override
    public String getContentType() {
        return UserAccount.class.getSimpleName();
    }

    @Override
    public UserAccount toDTO(
            DTOConverterContext dtoConverterContext,
            com.datamusic.app.model.UserAccount userAccount) throws Exception {

        return new UserAccount() {
            {
                setUserNameAccount(userAccount::getUserNameAccount);
                setUserFirstName(userAccount::getUserFirstName);
                setUserLastName(userAccount::getUserLastName);
            }
        };
    }

}
