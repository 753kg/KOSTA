package com.kosta.sbproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* lombok.jar에 있는 기능 */
/*
@Getter
@Setter
@ToString
@EqualsAndHashCode
==> @Data
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor	//NonNull인 것들만 모아서 생성자 만듦
@Builder	// 빌더패턴 (체이닝코드)
public class CarVO {
	
	@NonNull
	String model;
	
	int price;
	
	@NonNull
	String company;
	
}
