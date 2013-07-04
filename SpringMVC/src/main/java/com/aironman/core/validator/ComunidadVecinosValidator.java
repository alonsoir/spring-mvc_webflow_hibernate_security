package com.aironman.core.validator;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import com.aironman.core.pojos.ComunidadVecinos;

@Component
public class ComunidadVecinosValidator {

	public void validate(ComunidadVecinos comunidadVecinos, ValidationContext context) {
        MessageContext messages = context.getMessageContext();
        /*
        if (booking.getCheckinDate().before(today())) {
            messages.addMessage(new MessageBuilder().error().source("checkinDate").
                defaultText("Check in date must be a future date").build());
        } else if (!booking.getCheckinDate().before(booking.getCheckoutDate())) {
            messages.addMessage(new MessageBuilder().error().source("checkoutDate").
                defaultText("Check out date must be later than check in date").build());
        }
        */
        if (comunidadVecinos.getCp().length()!=5)
        	messages.addMessage(new MessageBuilder().error().source("cp").
                    defaultText("El codigo postal debe tener 5 caracteres").build());
    }
}
