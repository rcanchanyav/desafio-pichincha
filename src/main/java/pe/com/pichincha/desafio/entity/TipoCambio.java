package pe.com.pichincha.desafio.entity;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Entity
@Table(name = "EXCHANGE_RATE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambio extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "moneda_origen")
    @Enumerated(EnumType.ORDINAL)
    private Moneda monedaOrigen;

    @Column(name = "moneda_destino")
    @Enumerated(EnumType.ORDINAL)
    private Moneda monedaDestino;

    @Column(name = "tipo_cambio")
    private double tipoCambio;
}



