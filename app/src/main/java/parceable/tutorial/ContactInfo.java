package parceable.tutorial;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by CrossoOverNepal on 3/2/2016.
 */
public class ContactInfo implements Parcelable {
    String name;
    String surname;
    int idx;
    Address address;

    //publilc constructor
    public ContactInfo(String name, String surname, int idx, Address address) {
        this.name = name;
        this.surname = surname;
        this.idx = idx;
        this.address = address;
    }


    //Creator
    public static final Parcelable.Creator<ContactInfo> CREATOR = new Parcelable.Creator<ContactInfo>() {


        @Override
        public ContactInfo createFromParcel(Parcel in) {
            return new ContactInfo(in);
        }

        @Override
        public ContactInfo[] newArray(int size) {
            return new ContactInfo[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeInt(idx);

        // Add inner class
        dest.writeParcelable(address, flags);
    }


    //De-parcel object
    public ContactInfo(Parcel in) {
        name = in.readString();
        surname = in.readString();
        idx = in.readInt();

        address = (Address) in.readParcelable(Address.class.getClassLoader());
    }


    //this is inner class Address
    public static class Address implements Parcelable {
        private String street;
        private String city;
        private int number;

        public Address(String street, String city, int number) {
            this.street = street;
            this.city = city;
            this.number = number;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(street);
            dest.writeString(city);
            dest.writeInt(number);
        }

        // Creator
        public static final Parcelable.Creator<Address>
                CREATOR
                = new Parcelable.Creator<Address>
                () {
            public Address createFromParcel(Parcel in) {
                return new Address(in);
            }

            public Address[] newArray(int size) {
                return new Address[size];
            }
        };

        // "De-parcel object
        private Address(Parcel in) {
            street = in.readString();
            city = in.readString();
            number = in.readInt();
        }


    }


}
