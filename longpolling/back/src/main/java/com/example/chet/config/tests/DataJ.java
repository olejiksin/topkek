package com.example.chet.config.tests;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class DataJ {
    private String unCorLog;
    private String unCorPass;
    private String corPass;
    private String corLog;
    private String url;
}
