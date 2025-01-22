export interface Team {
  teamId: number;
  teamName: string;
  school: string;
  category: string;
}

export interface Pin {
  pinId: number;
  pin: string;
  pinType: string;
  pinCategory: string | null;
  ownerName: string;
  company: string;
}

export interface companies{
  pinType: string;
  company: string;
  ownerName: string;
}