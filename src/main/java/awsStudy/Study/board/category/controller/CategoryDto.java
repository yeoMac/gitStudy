package awsStudy.Study.board.category.controller;

import awsStudy.Study.board.entity.Board;
import awsStudy.Study.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {

    Long id;

    String name;


}
