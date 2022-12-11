package com.mrcool.webapp.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @Component
public class Greeting {

	private String message;

}
