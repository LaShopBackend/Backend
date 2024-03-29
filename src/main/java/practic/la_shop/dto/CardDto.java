package practic.la_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practic.la_shop.models.Card;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDto {

    private long id;
    private String paySystem;
    private String cardNumber;
    private String cardDate;
    private String cardCVV;
    private long accountId;

    public static CardDto from(Card card) {
        return CardDto.builder()
                .id(card.getId())
                .paySystem(card.getPaySystem())
                .cardNumber(card.getCardNumber())
                .cardDate(card.getCardDate())
                .cardCVV(card.getCardCVV())
                .accountId(card.getAccountId().getId())
                .build();
    }

    public static List<CardDto> from(List<Card> cards) {
        return cards.stream().map(CardDto::from).toList();
    }

}
