/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

// javabeans↓↓
// publicで引数のないコンストラクタ（初期化処理）を持つ 
// フィールドは隠匿化されている
// getter/setterをもつ
// シリアライズ可能であること（class クラス名 implements Serializable{}）※importが必要


import java.io.Serializable;

// シリアライズ可能にするためにクラス名の後ろに implements Serializable を記入
public class UserDataBeans implements Serializable{
    
    // publicで引数のないコンストラクタ
    public UserDataBeans(){}
    
    // 隠匿化(private)されたフィールドの作成
    private String name_field = "";
    private String year_field = "";
    private String month_field = "";
    private String day_field = "";
    private String type_field = "";
    private String tell_field = "";
    private String comment_field = "";
    
    
    // getterの命名規則 → 「get」で開始し、以降の単語の頭文字を大文字にして宣言する
    // booleanの場合は、「is」で開始する
    public String getName(){
        return this.name_field;
    }
    
    public String getYear(){
        return this.year_field;
    }
    
    public String getMonth(){
        return this.month_field;
    }
    
    public String getDay(){
        return this.day_field;
    }
    
    public String getType(){
        return this.type_field;
    }
    
    public String getTell(){
        return this.tell_field;
    }
    
    public String getComment(){
        return this.comment_field;
    }
    
   
    // setterの命名規則：setで開始し、以降の単語の頭文字を大文字にして宣言する
    public void setName(String name){
        this.name_field = name;
    }
    
    public void setYear(String year){
        this.year_field = year;
    }
    
    public void setMonth(String month){
        this.month_field = month;
    }
    
    public void setDay(String day){
        this.day_field = day;
    }
    
    public void setType(String type){
        this.type_field = type;
    }
    
    public void setTell(String tell){
        this.tell_field = tell;
    }
    
    public void setComment(String comment){
        this.comment_field = comment;
    }
}